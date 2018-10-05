package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.WithText;

public class WithTextBindStatementBuilder extends BindStatementBuilder<WithText> {

    WithTextBindStatementBuilder() {
        super(WithText.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithText annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithTextMatcher(2131230885);
        builder.addStatement("$NBuilder.appendWithIdMatcher($S)",
                annotatedField,
                annotationInstance.value());
    }
}
