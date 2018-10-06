package jackknife.espresso;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
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
import static android.support.test.espresso.matcher.ViewMatchers.withAlpha;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class EspressoInstrumentationBuilder implements InstrumentationBuilder {

    private ArrayList<Matcher<? super View>> matchers;
    private Context applicationContext;

    public EspressoInstrumentationBuilder(Context applicationContext) {
        this.applicationContext = applicationContext;
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
    public void appendWithAlphaMatcher(final float alpha) {
        matchers.add(withAlpha(alpha));
    }

    @Override
    public void appendWithContentDescriptionMatcher(@StringRes final int stringResId) {
        appendWithContentDescriptionMatcher(applicationContext.getString(stringResId));
    }

    @Override
    public void appendWithContentDescriptionMatcher(final String text) {
        matchers.add(ViewMatchers.withContentDescription(text));
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
    public void appendWithTextMatcher(@StringRes final int stringResId) {
        appendWithTextMatcher(applicationContext.getString(stringResId));
    }

    @Override
    public void appendWithTagKeyMatcher(final int tagKey) {
        matchers.add(ViewMatchers.withTagKey(tagKey));
    }

    @Override
    public void appendIsAssignableFromMatcher(final Class clazz) {
        matchers.add(isAssignableFrom(clazz));
    }



    //TODO:ViewMatchers.withClassName();
    //TODO:ViewMatchers.withContentDescription(String);
    //TODO:ViewMatchers.withContentDescription(resId);
    //TODO:ViewMatchers.withEffectiveVisibility(Visibility);
    //TODO:ViewMatchers.withHint(resId);
    //TODO:ViewMatchers.withHint(String);
    //TODO:ViewMatchers.withSubstring();
    //TODO:ViewMatchers.withParentIndex();
    //TODO:ViewMatchers.withInputType(int);
    //TODO:ViewMatchers.withResourceName();
    //TODO:ViewMatchers.withSpinnerText(str);
    //TODO:ViewMatchers.withSpinnerText(int);

    //TODO:ViewMatchers.hasBackground();
    //TODO:ViewMatchers.hasChildCount();
    //TODO:ViewMatchers.hasContentDescription();
    //TODO:ViewMatchers.hasErrorText();
    //TODO:ViewMatchers.hasFocus();
    //TODO:ViewMatchers.hasImeAction();
    //TODO:ViewMatchers.hasLinks();
    //TODO:ViewMatchers.hasMinimumChildCount();
    //TODO:ViewMatchers.hasTextColor();
}
