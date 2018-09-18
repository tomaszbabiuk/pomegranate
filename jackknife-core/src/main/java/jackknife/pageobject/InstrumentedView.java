package jackknife.pageobject;

import android.support.annotation.IdRes;

import jackknife.core.InstrumentationContext;
import jackknife.core.InstrumentationContextNotCreatedException;
import jackknife.core.InstrumentationContextResolver;

public class InstrumentedView<T extends PageObject> {

    final int buttonId;
    final Class<T> nextPageObjectType;

    public InstrumentedView(@IdRes int buttonId, Class<T> nextPageObjectType) {
        this.buttonId = buttonId;
        this.nextPageObjectType = nextPageObjectType;
    }

    public T click() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performClick(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T doubleClick() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performDoubleClick(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T longClick() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performLongClick(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T pressBack() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performPressBack(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T pressImeActionButton() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performPressImeActionButton(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T pressKey(final int keyCode) throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performPressKey(buttonId, keyCode);

        return Factory.reuse(nextPageObjectType);
    }

    public T pressMenuKey() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performPressMenuKey(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T closeSoftKeyboard() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performCloseSoftKeyboard(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T scrollTo() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performScrollTo(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T swipeLeft() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performSwipeLeft(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T swipeRight() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performSwipeRight(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T swipeUp() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performSwipeUp(buttonId);

        return Factory.reuse(nextPageObjectType);
    }

    public T swipeDown() throws InstrumentationContextNotCreatedException, IllegalAccessException, InstantiationException {
        InstrumentationContext context = InstrumentationContextResolver.resolve();
        context.performSwipeDown(buttonId);

        return Factory.reuse(nextPageObjectType);
    }
}
