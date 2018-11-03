package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsJavascriptEnabled;

public class IsJavascriptEnabledStatementBuilder extends BindStatementBuilder<IsJavascriptEnabled> {

    public IsJavascriptEnabledStatementBuilder(Messager messager) {
        super(IsJavascriptEnabled.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsJavascriptEnabled annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsJavascriptEnabledMatcher();
        builder.addStatement("$NBuilder.appendIsJavascriptEnabledMatcher()", annotatedField);
    }
}
