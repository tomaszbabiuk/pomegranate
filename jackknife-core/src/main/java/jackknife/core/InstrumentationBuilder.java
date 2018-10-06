package jackknife.core;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import jackknife.annotations.Visibility;
import jackknife.pageobject.InstrumentedView;

public interface InstrumentationBuilder {

    <T extends InstrumentedView> T build(Class<T> clazz);

    void appendWithAlphaMatcher(float alpha);

    void appendWithContentDescriptionMatcher(@StringRes int stringResId);

    void appendWithContentDescriptionMatcher(String text);

    void appendWithIdMatcher(@IdRes final int id);

    void appendIsDescendantOfMatcher(@IdRes int id);

    void appendWithTextMatcher(String text);

    void appendWithTextMatcher(@StringRes int stringResId);

    void appendWithTagKeyMatcher(int tagKey);

    void appendIsAssignableFromMatcher(Class clazz);

    void appendWithEffectiveVisibilityMatcher(Visibility visibility);
}
