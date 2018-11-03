package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.WithInputType;
import jackknife.annotations.WithParentIndex;

public class WithParentIndexBindStatementBuilder extends BindStatementBuilder<WithParentIndex> {

    public WithParentIndexBindStatementBuilder(Messager messager) {
        super(WithParentIndex.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithParentIndex annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithParentIndexMatcher(2131230885);
        builder.addStatement("$NBuilder.appendWithParentIndexMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
