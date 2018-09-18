package poi.tb.core;

public class InstrumentationContextResolver {

    private static InstrumentationContext instance;

    public static InstrumentationContext resolve() throws InstrumentationContextNotCreatedException {
        if (instance == null) {
            throw new InstrumentationContextNotCreatedException("Instrumentation context doesn't exist. Call init first!");
        }

        return instance;
    }

    public static void set(InstrumentationContext context) {
        instance = context;
    }
}
