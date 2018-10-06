package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.HasFocus;

public class HasFocusStatementBuilder extends BindStatementBuilder<HasFocus> {

    public HasFocusStatementBuilder(Messager messager) {
        super(HasFocus.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasFocus annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasFocusMatcher();
        builder.addStatement("$NBuilder.appendHasFocusMatcher()", annotatedField);
    }
}
