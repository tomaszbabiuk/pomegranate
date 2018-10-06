package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsSelected;

public class IsSelectedStatementBuilder extends BindStatementBuilder<IsSelected> {

    public IsSelectedStatementBuilder(Messager messager) {
        super(IsSelected.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsSelected annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsSelectedMatcher();
        builder.addStatement("$NBuilder.appendIsSelectedMatcher()", annotatedField);
    }
}
