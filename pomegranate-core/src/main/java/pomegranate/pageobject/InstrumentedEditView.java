package pomegranate.pageobject;

public interface InstrumentedEditView extends InstrumentedTextView {
    void clearText();

    void typeText(final String text);

    void typeTextIntoFocusedView(final String text);

    void replaceText(final String text);
}
