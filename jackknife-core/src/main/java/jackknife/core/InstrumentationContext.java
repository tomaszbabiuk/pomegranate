package jackknife.core;

import android.support.annotation.IdRes;

import jackknife.pageobject.InstrumentedTextView;

public interface InstrumentationContext {
    InstrumentedTextView resolveInstrumentedViewById(@IdRes final int id);
}
