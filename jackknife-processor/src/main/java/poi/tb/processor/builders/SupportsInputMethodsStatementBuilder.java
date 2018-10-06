package poi.tb.processor.builders;

        import com.squareup.javapoet.MethodSpec;

        import javax.annotation.processing.Messager;
        import javax.lang.model.element.Name;

        import jackknife.annotations.SupportsInputMethods;

public class SupportsInputMethodsStatementBuilder extends BindStatementBuilder<SupportsInputMethods> {

    public SupportsInputMethodsStatementBuilder(Messager messager) {
        super(SupportsInputMethods.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final SupportsInputMethods annotationInstance) {
        //example: termsAndConditionsBuilder.appendSupportsInputMethodsMatcher();
        builder.addStatement("$NBuilder.appendSupportsInputMethodsMatcher()", annotatedField);
    }
}
