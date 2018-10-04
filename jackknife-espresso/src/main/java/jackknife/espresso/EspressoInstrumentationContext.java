package jackknife.espresso;

import android.support.annotation.IdRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Matcher;

import jackknife.core.InstrumentationContext;
import jackknife.pageobject.InstrumentedTextView;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class EspressoInstrumentationContext implements InstrumentationContext {
    @Override
    public InstrumentedTextView resolveInstrumentedViewById(@IdRes final int id) {
        Matcher<View> matcher = ViewMatchers.withId(id);
        return new EspressoInstrumentedTextView(matcher);
    }

    @Override
    public InstrumentedTextView resolveInstrumentedViewByParentId(@IdRes final int id) {
        Matcher<View> matcher = isDescendantOfA(withId(id));
        return new EspressoInstrumentedTextView(matcher);
    }

    @Override
    public InstrumentedTextView resolveInstrumentedViewByText(final String text) {
        Matcher<View> matcher = ViewMatchers.withText(text);
        return new EspressoInstrumentedTextView(matcher);
    }

    @Override
    public InstrumentedTextView resolveInstrumentedViewTagKey(final int tagKey) {
        Matcher<View> matcher = ViewMatchers.withTagKey(tagKey);
        return new EspressoInstrumentedTextView(matcher);
    }

    @Override
    public InstrumentedTextView resolveInstrumentedViewByParentIdAndClass(final int id, final Class clazz) {
        Matcher<View> matcher = allOf(isDescendantOfA(withId(id)), isAssignableFrom(clazz));
        return new EspressoInstrumentedTextView(matcher);
    }
}
