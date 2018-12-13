package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.IsChecked;

public class IsCheckedBindStatementBuilder extends BindStatementBuilder<IsChecked> {

    public IsCheckedBindStatementBuilder(Messager messager) {
        super(IsChecked.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsChecked annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsCheckedMatcher();
        builder.addStatement("$NBuilder.appendIsCheckedMatcher()", annotatedField);
    }
}
