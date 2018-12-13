package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import pomegranate.annotations.WithSpinnerText;

public class WithSpinnerTextBindStatementBuilder extends BindStatementBuilder<WithSpinnerText> {

    public WithSpinnerTextBindStatementBuilder(Messager messager) {
        super(WithSpinnerText.class, messager);
    }

    @Override
    public boolean check(final WithSpinnerText annotationInstance) {
        if (annotationInstance.value().equals("") && annotationInstance.fromResource() == -1) {
            getMessager().printMessage(Diagnostic.Kind.ERROR, "Please provide value for annotation: " + getAnnotationClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithSpinnerText annotationInstance) {
        if (annotationInstance.fromResource() != -1) {
            //example: termsAndConditionsBuilder.appendWithSpinnerTextMatcher(2131230885);
            builder.addStatement("$NBuilder.appendWithSpinnerTextMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            //example: termsAndConditionsBuilder.appendWithTextMatcher("text");
            builder.addStatement("$NBuilder.appendWithSpinnerTextMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
