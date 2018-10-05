package jackknife.pageobject;

public interface InstrumentedView {

    void click();

    <T extends PageObject> T clickAndGo(Class<T> pageObjectClass) throws InstantiationException, IllegalAccessException;

    void doubleClick();

    void longClick();

    void pressBack();

    void pressImeActionButton();

    void pressKey(int keyCode);

    void pressMenuKey();

    void closeSoftKeyboard();

    void scrollTo();

    void swipeLeft();

    void swipeRight();

    void swipeUp();

    void swipeDown();
}
