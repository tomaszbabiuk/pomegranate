package jackknife.espresso;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;

import jackknife.core.InstrumentationContext;

public class EspressoInstrumentationContext implements InstrumentationContext {

    @Override
    public void performClick(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.click());
    }

    @Override
    public void performDoubleClick(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.doubleClick());
    }

    @Override
    public void performLongClick(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.longClick());
    }

    @Override
    public void performPressBack(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.pressBack());
    }

    @Override
    public void performPressImeActionButton(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.pressImeActionButton());
    }

    @Override
    public void performPressKey(final int buttonId, final int keyCode) {
        getViewInteractionById(buttonId).perform(ViewActions.pressKey(keyCode));
    }

    @Override
    public void performPressMenuKey(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.pressMenuKey());
    }

    @Override
    public void performCloseSoftKeyboard(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.closeSoftKeyboard());
    }

    @Override
    public void performScrollTo(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.scrollTo());
    }

    @Override
    public void performSwipeLeft(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.swipeLeft());
    }

    @Override
    public void performSwipeRight(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.swipeRight());
    }

    @Override
    public void performSwipeUp(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.swipeUp());
    }

    @Override
    public void performSwipeDown(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.swipeDown());
    }

    @Override
    public void performClearText(final int buttonId) {
        getViewInteractionById(buttonId).perform(ViewActions.clearText());
    }

    @Override
    public void performTypeText(final int buttonId, final String text) {
        getViewInteractionById(buttonId).perform(ViewActions.typeText(text));
    }

    @Override
    public void performTypeTextIntoFocusedView(final int buttonId, final String text) {
        getViewInteractionById(buttonId).perform(ViewActions.typeTextIntoFocusedView(text));
    }

    @Override
    public void performReplaceText(final int buttonId, final String text) {
        getViewInteractionById(buttonId).perform(ViewActions.replaceText(text));
    }

    private ViewInteraction getViewInteractionById(final int buttonId) {
        return Espresso.onView(ViewMatchers.withId(buttonId));
    }
}
