package jackknife.core;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import jackknife.pageobject.InstrumentedView;

public interface InstrumentationBuilder {

    <T extends InstrumentedView> T build(Class<T> clazz);

    void appendWithIdMatcher(@IdRes final int id);

    void appendIsDescendantOfMatcher(@IdRes int id);

    void appendWithTextMatcher(String text);

    void appendWithTextMatcher(@StringRes int stringResId);

    void appendWithTagKeyMatcher(int tagKey);

    void appendIsAssignableFromMatcher(Class clazz);

    void appendWithAlphaMatcher(float alpha);
}
