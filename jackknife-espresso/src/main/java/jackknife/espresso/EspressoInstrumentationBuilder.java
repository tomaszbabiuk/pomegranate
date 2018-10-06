package jackknife.espresso;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.ArrayList;

import jackknife.annotations.Visibility;
import jackknife.core.InstrumentationBuilder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.hasBackground;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.hasImeAction;
import static android.support.test.espresso.matcher.ViewMatchers.hasLinks;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isFocusable;
import static android.support.test.espresso.matcher.ViewMatchers.isJavascriptEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static android.support.test.espresso.matcher.ViewMatchers.withAlpha;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withParentIndex;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withSubstring;
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
        ViewInteraction interaction = onView(matcher);

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
    public void appendWithHintMatcher(final String text) {
        matchers.add(ViewMatchers.withHint(text));
    }

    @Override
    public void appendWithHintMatcher(@StringRes final int stringResId) {
        appendWithHintMatcher(applicationContext.getString(stringResId));
    }

    @Override
    public void appendWithTagKeyMatcher(final int tagKey) {
        matchers.add(ViewMatchers.withTagKey(tagKey));
    }

    @Override
    public void appendIsAssignableFromMatcher(final Class clazz) {
        matchers.add(isAssignableFrom(clazz));
    }

    @Override
    public void appendWithEffectiveVisibilityMatcher(final Visibility visibility) {
        ViewMatchers.Visibility espressoVisibility = mapToEspressoVisibility(visibility);
        matchers.add(withEffectiveVisibility(espressoVisibility));
    }

    @Override
    public void appendWithInputTypeMatcher(final int inputTypeFlags) {
        matchers.add(withInputType(inputTypeFlags));
    }

    @Override
    public void appendWithResourceNameMatcher(final String resourceName) {
        matchers.add(withResourceName(resourceName));
    }

    @Override
    public void appendWithSpinnerTextMatcher(final int stringResId) {
        appendWithSpinnerTextMatcher(applicationContext.getString(stringResId));
    }

    @Override
    public void appendWithSpinnerTextMatcher(final String spinnerText) {
        matchers.add(withSpinnerText(spinnerText));
    }

    @Override
    public void appendWithSubstringMatcher(final String substring) {
        matchers.add(withSubstring(substring));
    }

    @Override
    public void appendWithParentIndexMatcher(final int parentIndex) {
        matchers.add(withParentIndex(parentIndex));
    }

    @Override
    public void appendIsDisplayedMatcher() {
        matchers.add(isDisplayed());
    }

    @Override
    public void appendIsCheckedMatcher() {
        matchers.add(isChecked());
    }

    @Override
    public void appendIsCompletelyDisplayedMatcher() {
        matchers.add(isCompletelyDisplayed());
    }

    @Override
    public void appendIsClickableMatcher() {
        matchers.add(isClickable());
    }

    @Override
    public void appendIsDisplayingAtLeastMatcher(final int percent) {
        matchers.add(isDisplayingAtLeast(percent));
    }

    @Override
    public void appendIsFocusableMatcher() {
        matchers.add(isFocusable());
    }

    @Override
    public void appendIsRootMatcher() {
        matchers.add(isRoot());
    }

    @Override
    public void appendIsSelectedMatcher() {
        matchers.add(isSelected());
    }

    @Override
    public void appendIsNotCheckedMatcher() {
        matchers.add(isNotChecked());
    }

    @Override
    public void appendIsJavascriptEnabledMatcher() {
        matchers.add(isJavascriptEnabled());
    }

    @Override
    public void appendIsEnabledMatcher() {
        matchers.add(isEnabled());
    }

    @Override
    public void appendHasBackgroundMatcher(final int drawableResId) {
        matchers.add(hasBackground(drawableResId));
    }

    @Override
    public void appendHasChildCountMatcher(final int childCount) {
        matchers.add(hasChildCount(childCount));
    }

    @Override
    public void appendHasContentDescriptionMatcher() {
        matchers.add(hasContentDescription());
    }

    @Override
    public void appendSupportsInputMethodsMatcher() {
        matchers.add(supportsInputMethods());
    }

    @Override
    public void appendHasFocusMatcher() {
        matchers.add(hasFocus());
    }

    @Override
    public void appendHasLinksMatcher() {
        matchers.add(hasLinks());
    }

    @Override
    public void appendHasErrorTextMatcher(final int stringResId) {
        appendWithSpinnerTextMatcher(applicationContext.getString(stringResId));
    }

    @Override
    public void appendHasErrorTextMatcher(final String error) {
        matchers.add(hasErrorText(error));
    }

    @Override
    public void appendHasMinimumChildCountMatcher(final int childCount) {
        matchers.add(hasMinimumChildCount(childCount));
    }

    @Override
    public void appendHasTextColorMatcher(@ColorRes final int colorResId) {
        matchers.add(hasTextColor(colorResId));
    }

    @Override
    public void appendHasImeActionMatcher(final int imeAction) {
        matchers.add(hasImeAction(imeAction));
    }

    @NonNull
    private ViewMatchers.Visibility mapToEspressoVisibility(final Visibility visibility) {
        switch (visibility) {
            case Gone:
                return ViewMatchers.Visibility.GONE;
            case Invisible:
                return  ViewMatchers.Visibility.INVISIBLE;
            default:
                return ViewMatchers.Visibility.VISIBLE;
        }
    }
}
