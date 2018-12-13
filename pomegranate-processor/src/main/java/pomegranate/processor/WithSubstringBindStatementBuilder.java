package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.WithSubstring;

public class WithSubstringBindStatementBuilder extends BindStatementBuilder<WithSubstring> {

    public WithSubstringBindStatementBuilder(Messager messager) {
        super(WithSubstring.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithSubstring annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithSubstringMatcher("substring");
        builder.addStatement("$NBuilder.appendWithSubstringMatcher($S)",
                annotatedField,
                annotationInstance.value());
    }
}
