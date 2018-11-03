package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.HasBackground;
import jackknife.annotations.HasChildCount;

public class HasChildCountBindStatementBuilder extends BindStatementBuilder<HasChildCount> {

    public HasChildCountBindStatementBuilder(Messager messager) {
        super(HasChildCount.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasChildCount annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasChildCountMatcher(2131230885);
        builder.addStatement("$NBuilder.appendHasChildCountMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
