package pomegranate.espresso;

import android.content.Context;

import pomegranate.core.InstrumentationBuilder;
import pomegranate.core.InstrumentationContext;


public class EspressoInstrumentationContext implements InstrumentationContext {

    private final Context applicationContext;

    public EspressoInstrumentationContext(Context applicationContext) {
        this.applicationContext = applicationContext.getApplicationContext();
    }

    @Override
    public InstrumentationBuilder createBuilder() {
        return new EspressoInstrumentationBuilder(applicationContext);
    }
}
