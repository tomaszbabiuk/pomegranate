package pomegranate.espresso;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import pomegranate.pageobject.InstrumentedEditView;

public class EspressoInstrumentedEditView extends EspressoInstrumentedTextView implements InstrumentedEditView {

    public EspressoInstrumentedEditView(final ViewInteraction viewInteraction) {
        super(viewInteraction);
    }

    @Override
    public void clearText() {
        viewInteraction.perform(ViewActions.clearText());
    }

    @Override
    public void typeText(final String text) {
        viewInteraction.perform(ViewActions.typeText(text));
    }

    @Override
    public void typeTextIntoFocusedView(final String text) {
        viewInteraction.perform(ViewActions.typeTextIntoFocusedView(text));
    }

    @Override
    public void replaceText(final String text) {
        viewInteraction.perform(ViewActions.replaceText(text));
    }
}
