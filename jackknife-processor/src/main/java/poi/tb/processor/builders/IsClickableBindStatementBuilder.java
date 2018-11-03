package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsClickable;
import jackknife.annotations.IsDisplayed;

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
