package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.WithId;

public class WithIdBindStatementBuilder extends BindStatementBuilder<WithId> {

    WithIdBindStatementBuilder() {
        super(WithId.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithId annotationInstance) {
        //example: termsAndConditionsBuilder.appendByIdMatcher(2131230885);
        builder.addStatement("$NBuilder.appendByIdMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
