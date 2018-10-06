package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import jackknife.annotations.WithText;

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
        //example: termsAndConditionsBuilder.appendWithTextMatcher(2131230885);
        if (annotationInstance.fromResource() != -1) {
            builder.addStatement("$NBuilder.appendWithTextMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            builder.addStatement("$NBuilder.appendWithTextMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
