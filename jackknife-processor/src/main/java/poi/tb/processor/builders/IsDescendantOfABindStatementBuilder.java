package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsDescendantOfA;

public class IsDescendantOfABindStatementBuilder extends BindStatementBuilder<IsDescendantOfA> {

    public IsDescendantOfABindStatementBuilder(Messager messager) {
        super(IsDescendantOfA.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsDescendantOfA annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsDescendantOfMatcher(123412341243);

        builder.addStatement("$NBuilder.appendIsDescendantOfMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
