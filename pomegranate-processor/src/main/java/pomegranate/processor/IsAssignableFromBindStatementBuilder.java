package pomegranate.processor;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.lang.model.type.MirroredTypeException;

import pomegranate.annotations.IsAssignableFrom;

public class IsAssignableFromBindStatementBuilder extends BindStatementBuilder<IsAssignableFrom> {

    public IsAssignableFromBindStatementBuilder(Messager messager) {
        super(IsAssignableFrom.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final IsAssignableFrom annotationInstance) {
        //example: termsAndConditionsBuilder.appendIsAssignableFromMatcher(TextView.class);

        try {
            annotationInstance.value();
        } catch (MirroredTypeException mte) {
            builder.addStatement("$NBuilder.appendIsAssignableFromMatcher($T.class)",
                    annotatedField,
                    mte.getTypeMirror());
        }
    }
}
