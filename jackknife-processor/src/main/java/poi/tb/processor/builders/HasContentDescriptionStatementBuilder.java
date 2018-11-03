package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.HasContentDescription;

public class HasContentDescriptionStatementBuilder extends BindStatementBuilder<HasContentDescription> {

    public HasContentDescriptionStatementBuilder(Messager messager) {
        super(HasContentDescription.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasContentDescription annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasContentDescriptionMatcher();
        builder.addStatement("$NBuilder.appendHasContentDescriptionMatcher()", annotatedField);
    }
}
