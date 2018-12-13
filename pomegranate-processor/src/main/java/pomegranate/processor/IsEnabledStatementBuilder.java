package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.IsEnabled;

public class IsEnabledStatementBuilder extends BindStatementBuilder<IsEnabled> {

    public IsEnabledStatementBuilder(Messager messager) {
        super(IsEnabled.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsEnabled annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsEnabledMatcher();
        builder.addStatement("$NBuilder.appendIsEnabledMatcher()", annotatedField);
    }
}
