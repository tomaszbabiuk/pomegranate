package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.Visibility;
import jackknife.annotations.WithEffectiveVisibility;

public class WithEffectiveVisibilityBindStatementBuilder extends BindStatementBuilder<WithEffectiveVisibility> {

    public WithEffectiveVisibilityBindStatementBuilder(Messager messager) {
        super(WithEffectiveVisibility.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithEffectiveVisibility annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithEffectiveVisibilityMatcher(Visibility.Gone);
        builder.addStatement("$NBuilder.appendWithEffectiveVisibilityMatcher($T.$L)",
                annotatedField,
                Visibility.class,
                annotationInstance.value());
    }
}
