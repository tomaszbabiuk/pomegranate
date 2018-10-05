package jackknife.core;

import android.support.annotation.IdRes;

import jackknife.pageobject.InstrumentedView;

public interface InstrumentationBuilder {

    InstrumentedView build();

    void appendByIdMatcher(@IdRes final int id);

    void appendDescendantOfMatcher(@IdRes int id);

    void appendTextMatcher(String text);

    void appendTagKeyMatcher(int tagKey);

    void appendIsAssignableFromMatcher(Class clazz);
}
