package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsChecked;
import jackknife.annotations.IsDisplayed;

public class IsDisplayedBindStatementBuilder extends BindStatementBuilder<IsDisplayed> {

    public IsDisplayedBindStatementBuilder(Messager messager) {
        super(IsDisplayed.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsDisplayed annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsDisplayedMatcher();
        builder.addStatement("$NBuilder.appendIsDisplayedMatcher()", annotatedField);
    }
}
