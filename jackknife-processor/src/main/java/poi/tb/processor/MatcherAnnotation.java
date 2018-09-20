package poi.tb.processor;

import java.lang.annotation.Annotation;

public class MatcherAnnotation<A extends Annotation, V> {

    public interface AnnotationValueReaderDelegate<T, A extends Annotation> {
        T getAnnotationValue(final A annotation);
    }

    private Class<A> annotationClass;
    private AnnotationValueReaderDelegate<V, A> reader;
    private String javaPoetBindStatement;

    MatcherAnnotation(final Class<A> annotationClass,
                      final AnnotationValueReaderDelegate<V, A> reader,
                      final String javaPoetBindStatement) {

        this.annotationClass = annotationClass;
        this.reader = reader;
        this.javaPoetBindStatement = javaPoetBindStatement;
    }

    public Class<A> getAnnotationClass() {
        return annotationClass;
    }

    public AnnotationValueReaderDelegate<V, A> getReader() {
        return reader;
    }

    public String getJavaPoetBindStatement() {
        return javaPoetBindStatement;
    }
}
