package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.WithInputType;

public class WithInputTypeBindStatementBuilder extends BindStatementBuilder<WithInputType> {

    public WithInputTypeBindStatementBuilder(Messager messager) {
        super(WithInputType.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithInputType annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithInputTypeMatcher(2131230885);
        builder.addStatement("$NBuilder.appendWithInputTypeMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
