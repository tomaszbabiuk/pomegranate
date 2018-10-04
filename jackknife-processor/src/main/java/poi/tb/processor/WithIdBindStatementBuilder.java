package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.WithId;

public class WithIdBindStatementBuilder extends BindStatementBuilder<WithId> {

    WithIdBindStatementBuilder() {
        super(WithId.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithId annotationInstance) {
        builder.addStatement("$N.$N = instrumentationContext.resolveInstrumentedViewById($L)",
                "target",
                annotatedField,
                annotationInstance.value());
    }
}
