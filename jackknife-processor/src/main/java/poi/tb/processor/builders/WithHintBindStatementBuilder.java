package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import jackknife.annotations.WithHint;

public class WithHintBindStatementBuilder extends BindStatementBuilder<WithHint> {

    public WithHintBindStatementBuilder(Messager messager) {
        super(WithHint.class, messager);
    }

    @Override
    public boolean check(final WithHint annotationInstance) {
        if (annotationInstance.value().equals("") && annotationInstance.fromResource() == -1) {
            getMessager().printMessage(Diagnostic.Kind.ERROR, "Please provide value for annotation: " + getAnnotationClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithHint annotationInstance) {
        if (annotationInstance.fromResource() != -1) {
            //example: termsAndConditionsBuilder.appendWithHintMatcher(2131230885);
            builder.addStatement("$NBuilder.appendWithHintMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            //example: termsAndConditionsBuilder.appendWithHintMatcher("text");
            builder.addStatement("$NBuilder.appendWithHintMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
