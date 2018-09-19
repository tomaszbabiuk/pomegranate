package jackknife.espresso;

import android.support.test.espresso.action.ViewActions;
import android.view.View;

import org.hamcrest.Matcher;

import jackknife.pageobject.InstrumentedTextView;

public class EspressoInstrumentedTextView extends EspressoInstrumentedView implements InstrumentedTextView {

    public EspressoInstrumentedTextView(Matcher<View> matcher) {
        super(matcher);
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
