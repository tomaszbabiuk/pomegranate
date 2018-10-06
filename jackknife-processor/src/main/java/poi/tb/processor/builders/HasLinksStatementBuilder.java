package poi.tb.processor.builders;

        import com.squareup.javapoet.MethodSpec;

        import javax.annotation.processing.Messager;
        import javax.lang.model.element.Name;

        import jackknife.annotations.HasLinks;

public class HasLinksStatementBuilder extends BindStatementBuilder<HasLinks> {

    public HasLinksStatementBuilder(Messager messager) {
        super(HasLinks.class, messager);
    }

    @Override
    public void build(final MethodSpec.Builder builder, final Name annotatedField, final HasLinks annotationInstance) {
        //example: termsAndConditionsBuilder.appendHasLinksMatcher();
        builder.addStatement("$NBuilder.appendHasLinksMatcher()", annotatedField);
    }
}
