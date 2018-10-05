package poi.tb.processor;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import jackknife.core.InstrumentationBuilder;
import jackknife.core.InstrumentationContext;
import jackknife.core.InstrumentationContextResolver;

public class PoiProcessor extends AbstractProcessor {
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnvironment) {
        if (annotations.size() > 0) {
            try {
                Set<VariableElement> allFields = gatherAllAnnotatedFields(roundEnvironment);
                final Map<Element, List<VariableElement>> fieldsGroupedByElements = group(allFields);

                TypeSpec.Builder classBuilder = TypeSpec.classBuilder("PageObjectBinder")
                        .addModifiers(Modifier.PUBLIC);

                for (final Element element : fieldsGroupedByElements.keySet()) {
                    List<VariableElement> variableElements = fieldsGroupedByElements.get(element);

                    MethodSpec bindMethod = getBindMethodSpec(element, variableElements);
                    classBuilder.addMethod(bindMethod);
                }

                writeTypeSpecToFile(classBuilder.build());
            } catch (Exception ex) {
                messager.printMessage(Diagnostic.Kind.ERROR, ex.toString());
            }

            return true;
        }

        return false;
    }

    private Set<VariableElement> gatherAllAnnotatedFields(final RoundEnvironment roundEnvironment) {
        Set<VariableElement> allFields = new HashSet<>();
        for (BindStatementBuilder bindStatementBuilder : getSupportedAnnotations()) {
            final Set<VariableElement> fields = findAnnotatedFields(roundEnvironment, bindStatementBuilder.getAnnotationClass());
            allFields.addAll(fields);
        }

        return allFields;
    }

    private Set<VariableElement> findAnnotatedFields(final RoundEnvironment roundEnvironment, Class<? extends Annotation> annotationClass) {
        final Set<? extends Element> withIdElements = roundEnvironment.getElementsAnnotatedWith(annotationClass);
        return ElementFilter.fieldsIn(withIdElements);
    }

    private MethodSpec getBindMethodSpec(final Element element, final List<VariableElement> variableElements) {
        TypeName annotatedClass = TypeName.get(element.asType());
        ParameterSpec bindMethodParam = ParameterSpec.builder(annotatedClass, "target")
                .build();

        MethodSpec.Builder bindMethodBuilder = MethodSpec.methodBuilder("bind")
                .addParameter(bindMethodParam)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        generateContextResolverStatement(bindMethodBuilder);

        for (VariableElement annotatedField : variableElements) {
            bindMethodBuilder.addComment("Bindings for $T", annotatedField.asType());
            generateInstrumentationBuilderStatement(bindMethodBuilder, annotatedField);
            generateBindStatements(bindMethodBuilder, annotatedField);
            generateFinalBuildStatement(bindMethodBuilder, annotatedField);
            bindMethodBuilder.addCode("\n");
        }

        return bindMethodBuilder.build();
    }

    private void generateFinalBuildStatement(final MethodSpec.Builder builder,
                                             final VariableElement annotatedField) {
        builder.addStatement("target.$N = $NBuilder.build($T.class)",
                annotatedField.getSimpleName(),
                annotatedField.getSimpleName(),
                TypeName.get(annotatedField.asType()));
    }

    private void generateInstrumentationBuilderStatement(final MethodSpec.Builder builder,
                                                         final VariableElement annotatedField) {
        TypeName instrumentationBuilderType = TypeName.get(InstrumentationBuilder.class);

        builder.addStatement("$T $NBuilder = instrumentationContext.createBuilder()",
                instrumentationBuilderType,
                annotatedField.getSimpleName());
    }

    private void generateContextResolverStatement(final MethodSpec.Builder builder) {
        TypeName instrumentationContextType = TypeName.get(InstrumentationContext.class);
        TypeName instrumentationContextResolverType = TypeName.get(InstrumentationContextResolver.class);

        builder.addStatement("$T $N = $T.resolve()",
                instrumentationContextType,
                "instrumentationContext",
                instrumentationContextResolverType);
    }

    private <A extends Annotation> void processAnnotation(final MethodSpec.Builder bindMethodBuilder,
                                                          final VariableElement annotatedField,
                                                          BindStatementBuilder<A> bindStatementBuilder) {
        A annotation = annotatedField.getAnnotation(bindStatementBuilder.getAnnotationClass());
        if (annotation != null) {
            bindStatementBuilder.build(bindMethodBuilder, annotatedField.getSimpleName(), annotation);
        }
    }

    private void writeTypeSpecToFile(TypeSpec typeSpec) {
        JavaFile javaFile = JavaFile.builder("jackknife.generated", typeSpec)
                .build();

        writeFile(javaFile);
    }

    private Map<Element, List<VariableElement>> group(final Set<VariableElement> fields) {
        Map<Element, List<VariableElement>> result = new HashMap<>();

        for (VariableElement field : fields) {
            final Element elem = field.getEnclosingElement();
            if (result.containsKey(elem)) {
                List<VariableElement> list = result.get(elem);
                list.add(field);
            } else {
                List<VariableElement> list = new ArrayList<>();
                list.add(field);
                result.put(elem, list);
            }
        }

        return result;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> result = new HashSet<>();
        for (BindStatementBuilder annotationClass : getSupportedAnnotations()) {
            result.add(annotationClass.getAnnotationClass().getCanonicalName());
        }

        return result;
    }

    private void writeFile(JavaFile javaFile) {
        Filer filer = processingEnv.getFiler();

        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            Messager messager = processingEnv.getMessager();
            String message = String.format("Unable to write file: %s",
                    e.getMessage());
            messager.printMessage(Diagnostic.Kind.ERROR, message);
        }
    }

    private Set<BindStatementBuilder> getSupportedAnnotations() {
        Set<BindStatementBuilder> result = new HashSet<>();

        result.add(new WithIdBindStatementBuilder());
        result.add(new IsDescendantOfABindStatementBuilder());
        result.add(new IsAssignableFromBindStatementBuilder());
        result.add(new WithTagKeyBindStatementBuilder());
        result.add(new WithTextBindStatementBuilder());

        return result;
    }

    private void generateBindStatements(final MethodSpec.Builder bindMethodBuilder, final VariableElement annotatedField) {
        for (BindStatementBuilder annotation : getSupportedAnnotations()) {
            processAnnotation(bindMethodBuilder, annotatedField, annotation);
        }
    }
}

