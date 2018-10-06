package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsCompletelyDisplayed;
import jackknife.annotations.IsDisplayed;

public class IsCompletelyDisplayedBindStatementBuilder extends BindStatementBuilder<IsCompletelyDisplayed> {

    public IsCompletelyDisplayedBindStatementBuilder(Messager messager) {
        super(IsCompletelyDisplayed.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsCompletelyDisplayed annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsCompletelyDisplayedMatcher();
        builder.addStatement("$NBuilder.appendIsCompletelyDisplayedMatcher()", annotatedField);
    }
}
