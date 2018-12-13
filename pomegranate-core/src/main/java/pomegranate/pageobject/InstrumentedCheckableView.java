package pomegranate.pageobject;

public interface InstrumentedCheckableView extends InstrumentedTextView {
    void setChecked(boolean checked);

    boolean isChecked();

    void toggle();
}
