package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.HasImeAction;

public class HasImeActionBindStatementBuilder extends BindStatementBuilder<HasImeAction> {

    public HasImeActionBindStatementBuilder(Messager messager) {
        super(HasImeAction.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasImeAction annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasImeActionMatcher(2131230885);
        builder.addStatement("$NBuilder.appendHasImeActionMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
