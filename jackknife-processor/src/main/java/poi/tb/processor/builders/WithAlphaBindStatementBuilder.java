package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.WithAlpha;

public class WithAlphaBindStatementBuilder extends BindStatementBuilder<WithAlpha> {

    public WithAlphaBindStatementBuilder(Messager messager) {
        super(WithAlpha.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithAlpha annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithAlphaMatcher(0.1);
        builder.addStatement("$NBuilder.appendWithAlphaMatcher($Lf)",
                annotatedField,
                annotationInstance.value());
    }
}
