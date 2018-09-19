package jackknife.espresso;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import org.hamcrest.Matcher;

import jackknife.pageobject.Factory;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;

public class EspressoInstrumentedView implements InstrumentedView {

    protected final ViewInteraction viewInteraction;

    public EspressoInstrumentedView(Matcher<View> matcher) {
        this.viewInteraction = Espresso.onView(matcher);
    }

    @Override
    public void click() {
        viewInteraction.perform(ViewActions.click());
    }

    @Override
    public <T extends PageObject> T clickAndGo(final Class<T> pageObjectClass) throws InstantiationException, IllegalAccessException {
        click();
        return Factory.reuse(pageObjectClass);
    }

    @Override
    public void doubleClick() {
        viewInteraction.perform(ViewActions.doubleClick());
    }

    @Override
    public void longClick() {
        viewInteraction.perform(ViewActions.longClick());
    }

    @Override
    public void pressBack() {
        viewInteraction.perform(ViewActions.pressBack());
    }

    @Override
    public void pressImeActionButton() {
        viewInteraction.perform(ViewActions.pressImeActionButton());
    }

    @Override
    public void pressKey(final int keyCode) {
        viewInteraction.perform(ViewActions.pressKey(keyCode));
    }

    @Override
    public void pressMenuKey() {
        viewInteraction.perform(ViewActions.pressMenuKey());
    }

    @Override
    public void closeSoftKeyboard() {
        viewInteraction.perform(ViewActions.closeSoftKeyboard());
    }

    @Override
    public void scrollTo() {
        viewInteraction.perform(ViewActions.scrollTo());
    }

    @Override
    public void swipeLeft() {
        viewInteraction.perform(ViewActions.swipeLeft());
    }

    @Override
    public void swipeRight() {
        viewInteraction.perform(ViewActions.swipeRight());
    }

    @Override
    public void swipeUp() {
        viewInteraction.perform(ViewActions.swipeUp());
    }

    @Override
    public void swipeDown() {
        viewInteraction.perform(ViewActions.swipeDown());
    }
}
