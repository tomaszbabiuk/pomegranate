package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import pomegranate.annotations.WithText;

public class WithTextBindStatementBuilder extends BindStatementBuilder<WithText> {

    public WithTextBindStatementBuilder(Messager messager) {
        super(WithText.class, messager);
    }

    @Override
    public boolean check(final WithText annotationInstance) {
        if (annotationInstance.value().equals("") && annotationInstance.fromResource() == -1) {
            getMessager().printMessage(Diagnostic.Kind.ERROR, "Please provide value for annotation: " + getAnnotationClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithText annotationInstance) {
        if (annotationInstance.fromResource() != -1) {
            //example: termsAndConditionsBuilder.appendWithTextMatcher(2131230885);
            builder.addStatement("$NBuilder.appendWithTextMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            //example: termsAndConditionsBuilder.appendWithTextMatcher("text");
            builder.addStatement("$NBuilder.appendWithTextMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
