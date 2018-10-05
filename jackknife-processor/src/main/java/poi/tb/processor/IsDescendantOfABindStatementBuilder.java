package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.IsDescendantOfA;

public class IsDescendantOfABindStatementBuilder extends BindStatementBuilder<IsDescendantOfA> {

    IsDescendantOfABindStatementBuilder() {
        super(IsDescendantOfA.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsDescendantOfA annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsDescendantOfMatcher(123412341243);

        builder.addStatement("$NBuilder.appendIsDescendantOfMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
