package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.HasBackground;

public class HasBackgroundBindStatementBuilder extends BindStatementBuilder<HasBackground> {

    public HasBackgroundBindStatementBuilder(Messager messager) {
        super(HasBackground.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasBackground annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasBackgroundMatcher(2131230885);
        builder.addStatement("$NBuilder.appendHasBackgroundMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
