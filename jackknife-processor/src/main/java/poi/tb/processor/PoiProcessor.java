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
import poi.tb.processor.builders.BindStatementBuilder;
import poi.tb.processor.builders.HasBackgroundBindStatementBuilder;
import poi.tb.processor.builders.HasChildCountBindStatementBuilder;
import poi.tb.processor.builders.HasContentDescriptionStatementBuilder;
import poi.tb.processor.builders.HasErrorTextBindStatementBuilder;
import poi.tb.processor.builders.HasFocusStatementBuilder;
import poi.tb.processor.builders.HasImeActionBindStatementBuilder;
import poi.tb.processor.builders.HasLinksStatementBuilder;
import poi.tb.processor.builders.HasMinimumChildCountBindStatementBuilder;
import poi.tb.processor.builders.HasTextColorBindStatementBuilder;
import poi.tb.processor.builders.IsAssignableFromBindStatementBuilder;
import poi.tb.processor.builders.IsCheckedBindStatementBuilder;
import poi.tb.processor.builders.IsClickableBindStatementBuilder;
import poi.tb.processor.builders.IsCompletelyDisplayedBindStatementBuilder;
import poi.tb.processor.builders.IsDescendantOfABindStatementBuilder;
import poi.tb.processor.builders.IsDisplayedBindStatementBuilder;
import poi.tb.processor.builders.IsDisplayingAtLeastBindStatementBuilder;
import poi.tb.processor.builders.IsEnabledStatementBuilder;
import poi.tb.processor.builders.IsFocusableStatementBuilder;
import poi.tb.processor.builders.IsJavascriptEnabledStatementBuilder;
import poi.tb.processor.builders.IsNotCheckedStatementBuilder;
import poi.tb.processor.builders.IsRootStatementBuilder;
import poi.tb.processor.builders.IsSelectedStatementBuilder;
import poi.tb.processor.builders.SupportsInputMethodsStatementBuilder;
import poi.tb.processor.builders.WithAlphaBindStatementBuilder;
import poi.tb.processor.builders.WithContentDescriptionBindStatementBuilder;
import poi.tb.processor.builders.WithEffectiveVisibilityBindStatementBuilder;
import poi.tb.processor.builders.WithHintBindStatementBuilder;
import poi.tb.processor.builders.WithIdBindStatementBuilder;
import poi.tb.processor.builders.WithInputTypeBindStatementBuilder;
import poi.tb.processor.builders.WithParentIndexBindStatementBuilder;
import poi.tb.processor.builders.WithResourceNameBindStatementBuilder;
import poi.tb.processor.builders.WithSpinnerTextBindStatementBuilder;
import poi.tb.processor.builders.WithSubstringBindStatementBuilder;
import poi.tb.processor.builders.WithTagKeyBindStatementBuilder;
import poi.tb.processor.builders.WithTextBindStatementBuilder;

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
            bindMethodBuilder.addComment("Bindings for $S", annotatedField.getSimpleName());
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
            if (bindStatementBuilder.check(annotation)) {
                bindStatementBuilder.build(bindMethodBuilder, annotatedField.getSimpleName(), annotation);
            } else {
                messager.printMessage(Diagnostic.Kind.ERROR, "Error processing annotation: " +
                        annotation.getClass() + ", field: " + annotatedField.getSimpleName());
            }
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

        result.add(new HasBackgroundBindStatementBuilder(messager));
        result.add(new HasChildCountBindStatementBuilder(messager));
        result.add(new HasContentDescriptionStatementBuilder(messager));
        result.add(new HasErrorTextBindStatementBuilder(messager));
        result.add(new HasFocusStatementBuilder(messager));
        result.add(new HasImeActionBindStatementBuilder(messager));
        result.add(new HasLinksStatementBuilder(messager));
        result.add(new HasMinimumChildCountBindStatementBuilder(messager));
        result.add(new HasTextColorBindStatementBuilder(messager));

        result.add(new IsAssignableFromBindStatementBuilder(messager));
        result.add(new IsCheckedBindStatementBuilder(messager));
        result.add(new IsClickableBindStatementBuilder(messager));
        result.add(new IsCompletelyDisplayedBindStatementBuilder(messager));
        result.add(new IsDescendantOfABindStatementBuilder(messager));
        result.add(new IsDisplayedBindStatementBuilder(messager));
        result.add(new IsDisplayingAtLeastBindStatementBuilder(messager));
        result.add(new IsEnabledStatementBuilder(messager));
        result.add(new IsFocusableStatementBuilder(messager));
        result.add(new IsJavascriptEnabledStatementBuilder(messager));
        result.add(new IsNotCheckedStatementBuilder(messager));
        result.add(new IsRootStatementBuilder(messager));
        result.add(new IsSelectedStatementBuilder(messager));

        result.add(new WithAlphaBindStatementBuilder(messager));
        result.add(new WithContentDescriptionBindStatementBuilder(messager));
        result.add(new WithEffectiveVisibilityBindStatementBuilder(messager));
        result.add(new WithHintBindStatementBuilder(messager));
        result.add(new WithIdBindStatementBuilder(messager));
        result.add(new WithInputTypeBindStatementBuilder(messager));
        result.add(new WithParentIndexBindStatementBuilder(messager));
        result.add(new WithResourceNameBindStatementBuilder(messager));
        result.add(new WithSpinnerTextBindStatementBuilder(messager));
        result.add(new WithSubstringBindStatementBuilder(messager));
        result.add(new WithTagKeyBindStatementBuilder(messager));
        result.add(new WithTextBindStatementBuilder(messager));

        result.add(new SupportsInputMethodsStatementBuilder(messager));

        return result;
    }

    private void generateBindStatements(final MethodSpec.Builder bindMethodBuilder, final VariableElement annotatedField) {
        for (BindStatementBuilder annotation : getSupportedAnnotations()) {
            processAnnotation(bindMethodBuilder, annotatedField, annotation);
        }
    }
}

