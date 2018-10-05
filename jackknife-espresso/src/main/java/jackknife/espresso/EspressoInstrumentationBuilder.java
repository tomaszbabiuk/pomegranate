package jackknife.espresso;

import android.support.annotation.IdRes;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.ArrayList;

import jackknife.core.InstrumentationBuilder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class EspressoInstrumentationBuilder implements InstrumentationBuilder {

    private ArrayList<Matcher<? super View>> matchers;

    public EspressoInstrumentationBuilder() {
        matchers = new ArrayList<>();
    }

    @Override
    public <T extends InstrumentedView> T build(final Class<T> clazz) {
        Matcher matcher = matchers.size() > 1 ? allOf(matchers) : matchers.get(0);
        ViewInteraction interaction = Espresso.onView(matcher);

        if (clazz.isAssignableFrom(InstrumentedTextView.class)) {
            return (T) new EspressoInstrumentedTextView(interaction);
        }

        return (T) new EspressoInstrumentedView(interaction);
    }

    @Override
    public void appendWithIdMatcher(@IdRes final int id) {
        matchers.add(withId(id));
    }

    @Override
    public void appendIsDescendantOfMatcher(@IdRes final int id) {
        matchers.add(isDescendantOfA(withId(id)));
    }

    @Override
    public void appendWithTextMatcher(final String text) {
        matchers.add(ViewMatchers.withText(text));
    }

    @Override
    public void appendWithTagKeyMatcher(final int tagKey) {
        matchers.add(ViewMatchers.withTagKey(tagKey));
    }

    @Override
    public void appendIsAssignableFromMatcher(final Class clazz) {
        matchers.add(isAssignableFrom(clazz));
    }
}
