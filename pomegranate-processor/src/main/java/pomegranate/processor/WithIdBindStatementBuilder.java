package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.WithId;

public class WithIdBindStatementBuilder extends BindStatementBuilder<WithId> {

    public WithIdBindStatementBuilder(Messager messager) {
        super(WithId.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithId annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithIdMatcher(2131230885);
        builder.addStatement("$NBuilder.appendWithIdMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
