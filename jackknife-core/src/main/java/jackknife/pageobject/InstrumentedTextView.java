package jackknife.pageobject;

public interface InstrumentedTextView extends InstrumentedView {
    void clearText();

    void typeText(final String text);

    void typeTextIntoFocusedView(final String text);

    void replaceText(final String text);
}
