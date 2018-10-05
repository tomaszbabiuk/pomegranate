package jackknife.core;

import android.support.annotation.IdRes;

import jackknife.pageobject.InstrumentedView;

public interface InstrumentationBuilder {

    <T extends InstrumentedView> T build(Class<T> clazz);

    void appendWithIdMatcher(@IdRes final int id);

    void appendIsDescendantOfMatcher(@IdRes int id);

    void appendWithTextMatcher(String text);

    void appendWithTagKeyMatcher(int tagKey);

    void appendIsAssignableFromMatcher(Class clazz);
}
