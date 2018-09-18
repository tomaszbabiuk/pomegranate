package poi.tb.processor;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

import jackknife.annotations.WithId;

public class PoiProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnvironment) {
        messager.printMessage(Diagnostic.Kind.NOTE, "dupa2");

        if (annotations.size() > 0) {
            final Set<? extends Element> instrumentClickElements = roundEnvironment.getElementsAnnotatedWith(WithId.class);
            final Set<VariableElement> fields = ElementFilter.fieldsIn(instrumentClickElements);
            final Map<Element, List<VariableElement>> fieldsGroupedByElements = group(fields);

            TypeSpec.Builder classBuilder = TypeSpec.classBuilder("PageObjectBinder")
                    .addModifiers(Modifier.PUBLIC);

            for (final Element element : fieldsGroupedByElements.keySet()) {
                List<VariableElement> variableElements = fieldsGroupedByElements.get(element);

                MethodSpec bindMethod = getMethodSpec(element, variableElements);
                classBuilder.addMethod(bindMethod);
            }

            writeTypeSpecToFile("poi.tb.generated", classBuilder.build());

            return true;
        }

        return false;
    }

    private MethodSpec getMethodSpec(final Element element, final List<VariableElement> variableElements) {
        TypeName annotatedClass = TypeName.get(element.asType());
        ParameterSpec bindMethodParam = ParameterSpec.builder(annotatedClass, "target")
                .build();

        MethodSpec.Builder bindMethodBuilder = MethodSpec.methodBuilder("bind")
                .addParameter(bindMethodParam)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC);

        for (VariableElement annotatedField : variableElements) {
            generateBindStatement(bindMethodBuilder, annotatedField);
        }

        return bindMethodBuilder.build();
    }

    private void generateBindStatement(final MethodSpec.Builder bindMethodBuilder, final VariableElement annotatedField) {
        WithId withIdAnnotation = annotatedField.getAnnotation(WithId.class);
        int fieldId = withIdAnnotation.value();
        TypeName fieldClass = TypeName.get(annotatedField.asType());

        if (fieldClass instanceof ParameterizedTypeName) {
            fieldClass = ((ParameterizedTypeName) fieldClass).typeArguments.get(0);

            annotatedField.getSimpleName();
            bindMethodBuilder.addStatement("$N.$N = new $T<>($L, $T.class)",
                    "target",
                    annotatedField.getSimpleName(),
                    ClickPerformer.class,
                    fieldId,
                    fieldClass);
        } else {
            //todo: handle unmatching types
        }
    }

    private void writeTypeSpecToFile(String packageName, TypeSpec typeSpec) {
        JavaFile javaFile = JavaFile.builder(packageName, typeSpec)
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
        return Collections.singleton(WithId.class.getCanonicalName());
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
}

