package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;
import javax.lang.model.type.MirroredTypeException;

import jackknife.annotations.WithParentIdAndClass;

public class WithParentIdAndClassBindStatementBuilder extends BindStatementBuilder<WithParentIdAndClass> {

    WithParentIdAndClassBindStatementBuilder() {
        super(WithParentIdAndClass.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithParentIdAndClass annotationInstance) {
        try {
            annotationInstance.clazz();
        } catch (MirroredTypeException mte) {
            builder.addStatement("$N.$N = instrumentationContext.resolveInstrumentedViewByParentIdAndClass($L,$T.class)",
                    "target",
                    annotatedField,
                    annotationInstance.value(),
                    mte.getTypeMirror());
        }
    }
}
