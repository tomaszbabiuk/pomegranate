package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

import jackknife.annotations.IsRoot;

public class IsRootStatementBuilder extends BindStatementBuilder<IsRoot> {

    public IsRootStatementBuilder(Messager messager) {
        super(IsRoot.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsRoot annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsRootMatcher();
        builder.addStatement("$NBuilder.appendIsRootMatcher()", annotatedField);
    }
}
