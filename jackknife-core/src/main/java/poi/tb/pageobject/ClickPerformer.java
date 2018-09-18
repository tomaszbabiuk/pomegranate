package poi.tb.pageobject;

import android.support.annotation.IdRes;

import poi.tb.core.InstrumentationContext;
import poi.tb.core.InstrumentationContextNotCreatedException;
import poi.tb.core.InstrumentationContextResolver;

public class ClickPerformer<T extends PageObject> {

    private final int buttonId;
    private final Class<T> nextPageObjectType;

    public ClickPerformer(@IdRes int buttonId, Class<T> nextPageObjectType) {
        this.buttonId = buttonId;
        this.nextPageObjectType = nextPageObjectType;
    }

    public T click() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performClick(buttonId);

        return Factory.reuse(nextPageObjectType);
    }
}
