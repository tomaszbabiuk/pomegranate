package poi.tb.sample.pageobject;

import poi.tb.core.InstrumentationContext;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;
import static android.support.test.espresso.Espresso.onView;

public class EspressoInstrumentationContext implements InstrumentationContext {
    @Override
    public void performClick(final int buttonId) {
        onView(withId(buttonId)).perform(click());
    }
}
