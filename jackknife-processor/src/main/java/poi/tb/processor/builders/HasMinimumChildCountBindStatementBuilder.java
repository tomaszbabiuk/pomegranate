package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.HasMinimumChildCount;

public class HasMinimumChildCountBindStatementBuilder extends BindStatementBuilder<HasMinimumChildCount> {

    public HasMinimumChildCountBindStatementBuilder(Messager messager) {
        super(HasMinimumChildCount.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasMinimumChildCount annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasMinimumChildCountMatcher(2131230885);
        builder.addStatement("$NBuilder.appendHasMinimumChildCountMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
