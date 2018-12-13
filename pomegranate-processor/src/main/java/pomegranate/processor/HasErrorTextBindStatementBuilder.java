package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import pomegranate.annotations.HasErrorText;

public class HasErrorTextBindStatementBuilder extends BindStatementBuilder<HasErrorText> {

    public HasErrorTextBindStatementBuilder(Messager messager) {
        super(HasErrorText.class, messager);
    }

    @Override
    public boolean check(final HasErrorText annotationInstance) {
        if (annotationInstance.value().equals("") && annotationInstance.fromResource() == -1) {
            getMessager().printMessage(Diagnostic.Kind.ERROR, "Please provide value for annotation: " + getAnnotationClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasErrorText annotationInstance) {
        if (annotationInstance.fromResource() != -1) {
            //example: termsAndConditionsBuilder.appendHasErrorTextMatcher(2131230885);
            builder.addStatement("$NBuilder.appendHasErrorTextMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            //example: termsAndConditionsBuilder.appendHasErrorTextMatcher("text");
            builder.addStatement("$NBuilder.appendHasErrorTextMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
