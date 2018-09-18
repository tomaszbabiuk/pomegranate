package jackknife.pageobject;

import android.support.annotation.IdRes;

import jackknife.core.InstrumentationContext;
import jackknife.core.InstrumentationContextNotCreatedException;
import jackknife.core.InstrumentationContextResolver;

public class InstrumentedTextView<T extends PageObject> extends InstrumentedView<T> {

    public InstrumentedTextView(@IdRes int buttonId, Class<T> nextPageObjectType) {
        super(buttonId, nextPageObjectType);
    }

    public T clearText() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performClearText(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T typeText(final String text) throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performTypeText(buttonId, text);

        return Factory.reuse(nextPageObjectType);
    }

    public T typeTextIntoFocusedView(final String text) throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performTypeTextIntoFocusedView(buttonId, text);

        return Factory.reuse(nextPageObjectType);
    }

    public T replaceText(final String text) throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performReplaceText(buttonId, text);

        return Factory.reuse(nextPageObjectType);
    }
}
