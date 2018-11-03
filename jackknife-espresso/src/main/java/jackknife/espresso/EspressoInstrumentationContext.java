package jackknife.espresso;

import android.content.Context;

import jackknife.core.InstrumentationBuilder;
import jackknife.core.InstrumentationContext;


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
