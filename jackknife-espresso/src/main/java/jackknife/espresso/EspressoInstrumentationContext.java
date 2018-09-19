package jackknife.espresso;

import android.support.annotation.IdRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import jackknife.core.InstrumentationContext;
import jackknife.pageobject.InstrumentedTextView;


public class EspressoInstrumentationContext implements InstrumentationContext {
    @Override
    public InstrumentedTextView resolveInstrumentedViewById(@IdRes final int id) {
        Matcher<View> matcher = ViewMatchers.withId(id);
        return new EspressoInstrumentedTextView(matcher);
    }
}
