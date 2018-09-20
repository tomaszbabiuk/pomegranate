package jackknife.core;

import android.support.annotation.IdRes;

import jackknife.pageobject.InstrumentedTextView;

public interface InstrumentationContext {
    InstrumentedTextView resolveInstrumentedViewById(@IdRes final int id);

    InstrumentedTextView resolveInstrumentedViewByParentId(@IdRes int id);

    InstrumentedTextView resolveInstrumentedViewByText(String text);

    InstrumentedTextView resolveInstrumentedViewTagKey(int tagKey);
}
