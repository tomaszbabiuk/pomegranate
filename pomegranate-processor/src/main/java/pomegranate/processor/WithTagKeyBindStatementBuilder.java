package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.WithTagKey;

public class WithTagKeyBindStatementBuilder extends BindStatementBuilder<WithTagKey> {

    public WithTagKeyBindStatementBuilder(Messager messager) {
        super(WithTagKey.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithTagKey annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithTagKeyMatcher(2131230885);
        builder.addStatement("$NBuilder.appendWithTagKeyMatcher($L)",
                annotatedField,
                annotationInstance.value());
    }
}
