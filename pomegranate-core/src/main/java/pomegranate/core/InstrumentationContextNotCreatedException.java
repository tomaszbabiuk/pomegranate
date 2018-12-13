package pomegranate.core;

public class InstrumentationContextNotCreatedException extends RuntimeException {
    InstrumentationContextNotCreatedException(final String message) {
        super(message);
    }
}
