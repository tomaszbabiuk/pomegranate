package jackknife.pageobject;

import android.support.annotation.IdRes;

import jackknife.core.InstrumentationContext;
import jackknife.core.InstrumentationContextNotCreatedException;
import jackknife.core.InstrumentationContextResolver;

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
