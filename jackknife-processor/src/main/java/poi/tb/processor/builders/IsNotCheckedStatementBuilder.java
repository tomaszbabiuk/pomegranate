package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsNotChecked;

public class IsNotCheckedStatementBuilder extends BindStatementBuilder<IsNotChecked> {

    public IsNotCheckedStatementBuilder(Messager messager) {
        super(IsNotChecked.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsNotChecked annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsNotCheckedMatcher();
        builder.addStatement("$NBuilder.appendIsNotCheckedMatcher()", annotatedField);
    }
}
