package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsFocusable;

public class IsFocusableStatementBuilder extends BindStatementBuilder<IsFocusable> {

    public IsFocusableStatementBuilder(Messager messager) {
        super(IsFocusable.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsFocusable annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsFocusableMatcher();
        builder.addStatement("$NBuilder.appendIsFocusableMatcher()", annotatedField);
    }
}

