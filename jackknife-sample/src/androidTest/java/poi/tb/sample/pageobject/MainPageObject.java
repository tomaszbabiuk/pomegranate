package poi.tb.sample.pageobject;

import jackknife.annotations.WithId;
import jackknife.annotations.WithParentId;
import jackknife.annotations.WithTagKey;
import jackknife.annotations.WithText;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class MainPageObject extends PageObject {

    @WithParentId(R.id.navigation_test1)
    public InstrumentedView test1;

    @WithText("test2")
    public InstrumentedView test2;

    @WithId(R.id.navigation_test3)
    public InstrumentedView test3;

    @WithTagKey(123)
    public InstrumentedView test4;

    public MainPageObject() {
        PageObjectBinder.bind(this);
    }
}