package poi.tb.processor;

import com.squareup.javapoet.MethodSpec;

import java.lang.annotation.Annotation;

import javax.lang.model.element.Name;

public abstract class BindStatementBuilder<A extends Annotation> {
    private Class<A> annotationClass;

    BindStatementBuilder(final Class<A> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public Class<A> getAnnotationClass() {
        return annotationClass;
    }

    public abstract void build(MethodSpec.Builder builder, Name annotatedField, A annotationInstance);
}
