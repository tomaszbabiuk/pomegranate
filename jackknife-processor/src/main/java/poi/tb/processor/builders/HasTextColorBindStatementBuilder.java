package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.HasTextColor;

public class HasTextColorBindStatementBuilder extends BindStatementBuilder<HasTextColor> {

    public HasTextColorBindStatementBuilder(Messager messager) {
        super(HasTextColor.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasTextColor annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasTextColorMatcher(2131230885);
        builder.addStatement("$NBuilder.appendHasTextColorMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
