package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.IsClickable;

public class IsClickableBindStatementBuilder extends BindStatementBuilder<IsClickable> {

    public IsClickableBindStatementBuilder(Messager messager) {
        super(IsClickable.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsClickable annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsClickableMatcher();
        builder.addStatement("$NBuilder.appendIsClickableMatcher()", annotatedField);
    }
}
