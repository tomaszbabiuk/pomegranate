package pomegranate.espresso;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;

import pomegranate.pageobject.Factory;
import pomegranate.pageobject.InstrumentedView;
import pomegranate.pageobject.PageObject;

public class EspressoInstrumentedView implements InstrumentedView {

    protected final ViewInteraction viewInteraction;

    public EspressoInstrumentedView(final ViewInteraction viewInteraction) {
        this.viewInteraction = viewInteraction;
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
        performCustom(ViewActions.doubleClick());
    }

    @Override
    public void longClick() {
        performCustom(ViewActions.longClick());
    }

    @Override
    public void pressBack() {
        performCustom(ViewActions.pressBack());
    }

    @Override
    public void pressImeActionButton() {
        performCustom(ViewActions.pressImeActionButton());
    }

    @Override
    public void pressKey(final int keyCode) {
        performCustom(ViewActions.pressKey(keyCode));
    }

    @Override
    public void pressMenuKey() {
        performCustom(ViewActions.pressMenuKey());
    }

    @Override
    public void closeSoftKeyboard() {
        performCustom(ViewActions.closeSoftKeyboard());
    }

    @Override
    public void scrollTo() {
        performCustom(ViewActions.scrollTo());
    }

    @Override
    public void swipeLeft() {
        performCustom(ViewActions.swipeLeft());
    }

    @Override
    public void swipeRight() {
        performCustom(ViewActions.swipeRight());
    }

    @Override
    public void swipeUp() {
        performCustom(ViewActions.swipeUp());
    }

    @Override
    public void swipeDown() {
        performCustom(ViewActions.swipeDown());
    }

    public void performCustom(final ViewAction... viewActions) {
        viewInteraction.perform(viewActions);
    }




    @Override
    public void assertIsRoot() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isRoot()));
    }

    @Override
    public void assertIsAssignableFrom(final Class clazz) {
        assertCustom(ViewAssertions.matches(ViewMatchers.isAssignableFrom(clazz)));
    }

    @Override
    public void assertIsChecked() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isChecked()));
    }

    @Override
    public void assertIsClickable() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isClickable()));
    }

    @Override
    public void assertIsCompletelyDisplayed() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()));
    }

    @Override
    public void assertIsDisplayed() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Override
    public void assertIsDisplayedAtLeast(int areaPercentage) {
        assertCustom(ViewAssertions.matches(ViewMatchers.isDisplayingAtLeast(areaPercentage)));
    }

    @Override
    public void assertIsEnabled() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isEnabled()));
    }

    @Override
    public void assertIsJavascriptEnabled() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isJavascriptEnabled()));
    }

    @Override
    public void assertIsNotChecked() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isNotChecked()));
    }

    @Override
    public void assertIsSelected() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isSelected()));
    }

    @Override
    public void assertDoesNotExist() {
        assertCustom(ViewAssertions.doesNotExist());
    }

    @Override
    public void assertIsFocusable() {
        assertCustom(ViewAssertions.matches(ViewMatchers.isFocusable()));
    }

    public void assertCustom(ViewAssertion viewAssert) {
        viewInteraction.check(viewAssert);
    }
}
