package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.IsDisplayingAtLeast;

public class IsDisplayingAtLeastBindStatementBuilder extends BindStatementBuilder<IsDisplayingAtLeast> {

    public IsDisplayingAtLeastBindStatementBuilder(Messager messager) {
        super(IsDisplayingAtLeast.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsDisplayingAtLeast annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsDisplayingAtLeastMatcher(10);
        builder.addStatement("$NBuilder.appendIsDisplayingAtLeastMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
