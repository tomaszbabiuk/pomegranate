package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import pomegranate.annotations.WithResourceName;

public class WithResourceNameBindStatementBuilder extends BindStatementBuilder<WithResourceName> {

    public WithResourceNameBindStatementBuilder(Messager messager) {
        super(WithResourceName.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithResourceName annotationInstance) {
        //example: termsAndConditionsBuilder.appendWithResourceNameMatcher("resource.name");
        builder.addStatement("$NBuilder.appendWithResourceNameMatcher($S)",
                annotatedField,
                annotationInstance.value());
    }
}
