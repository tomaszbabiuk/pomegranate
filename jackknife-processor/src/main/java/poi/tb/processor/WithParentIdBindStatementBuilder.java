package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Name;

import jackknife.annotations.WithParentId;

public class WithParentIdBindStatementBuilder extends BindStatementBuilder<WithParentId> {

    WithParentIdBindStatementBuilder() {
        super(WithParentId.class);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final WithParentId annotationInstance) {
        builder.addStatement("$N.$N = instrumentationContext.resolveInstrumentedViewByParentId($L)",
                "target",
                annotatedField,
                annotationInstance.value());
    }
}
