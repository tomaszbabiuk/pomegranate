package jackknife.espresso;

import android.support.annotation.IdRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Matcher;

import jackknife.core.InstrumentationBuilder;
import jackknife.core.InstrumentationContext;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class EspressoInstrumentationContext implements InstrumentationContext {
    @Override
    public InstrumentationBuilder createBuilder() {
        return new EspressoInstrumentationBuilder();
    }
}
