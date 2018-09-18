package jackknife.espresso;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;

import jackknife.core.InstrumentationContext;



public class EspressoInstrumentationContext implements InstrumentationContext {
    @Override
    public void performClick(final int buttonId) {
        Espresso.onView(ViewMatchers.withId(buttonId)).perform(ViewActions.click());
    }
}
