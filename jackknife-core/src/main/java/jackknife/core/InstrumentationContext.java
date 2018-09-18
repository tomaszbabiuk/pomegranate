package jackknife.core;

public interface InstrumentationContext {

    void performClick(final int buttonId);
    void performDoubleClick(int buttonId);
    void performLongClick(int buttonId);
    void performPressBack(int buttonId);
    void performPressImeActionButton(int buttonId);
    void performPressKey(int buttonId, int keyCode);
    void performPressMenuKey(int buttonId);
    void performCloseSoftKeyboard(int buttonId);
    void performScrollTo(int buttonId);
    void performSwipeLeft(int buttonId);
    void performSwipeRight(int buttonId);
    void performSwipeUp(int buttonId);
    void performSwipeDown(int buttonId);
    void performClearText(int buttonId);
    void performTypeText(int buttonId, String text);
    void performTypeTextIntoFocusedView(int buttonId, String text);
    void performReplaceText(int buttonId, String text);
}
