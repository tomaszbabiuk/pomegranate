package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.WithId;
import jackknife.annotations.WithTagKey;

public class WithTagKeyBindStatementBuilder extends BindStatementBuilder<WithTagKey> {

    WithTagKeyBindStatementBuilder() {
        super(WithTagKey.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithTagKey annotationInstance) {
        builder.addStatement("$N.$N = instrumentationContext.resolveInstrumentedViewTagKey($L)",
                "target",
                annotatedField,
                annotationInstance.value());
    }
}
