package poi.tb.processor.builders;

import com.squareup.javapoet.MethodSpec;

import java.lang.annotation.Annotation;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;

public abstract class BindStatementBuilder<A extends Annotation> {

    private Class<A> annotationClass;
    private Messager messager;

    BindStatementBuilder(final Class<A> annotationClass, Messager messager) {
        this.annotationClass = annotationClass;
        this.messager = messager;
    }

    public Class<A> getAnnotationClass() {
        return annotationClass;
    }

    public boolean check(A annotationInstance) {
        return true;
    }

    public abstract void build(MethodSpec.Builder builder, Name annotatedField, A annotationInstance);

    public Messager getMessager() {
        return messager;
    }
}
