package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import jackknife.annotations.WithContentDescription;
import jackknife.annotations.WithText;

public class WithContentDescriptionBindStatementBuilder extends BindStatementBuilder<WithContentDescription> {

    public WithContentDescriptionBindStatementBuilder(Messager messager) {
        super(WithContentDescription.class, messager);
    }

    @Override
    public boolean check(final WithContentDescription annotationInstance) {
        if (annotationInstance.value().equals("") && annotationInstance.fromResource() == -1) {
            getMessager().printMessage(Diagnostic.Kind.ERROR, "Please provide value for annotation: " + getAnnotationClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithContentDescription annotationInstance) {
        if (annotationInstance.fromResource() != -1) {
            //example: termsAndConditionsBuilder.appendWithContentDescriptionMatcher(2131230885);
            builder.addStatement("$NBuilder.appendWithContentDescriptionMatcher($L)",
                    annotatedField,
                    annotationInstance.fromResource());
        } else {
            //example: termsAndConditionsBuilder.appendWithTextMatcher("text");
            builder.addStatement("$NBuilder.appendWithContentDescriptionMatcher($S)",
                    annotatedField,
                    annotationInstance.value());
        }
    }
}
