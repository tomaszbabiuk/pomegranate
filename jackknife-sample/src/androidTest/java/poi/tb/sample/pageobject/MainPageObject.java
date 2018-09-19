package poi.tb.sample.pageobject;

import jackknife.annotations.WithId;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class MainPageObject extends PageObject {

    @WithId(R.id.navigation_test1)
    public InstrumentedView test1;

    @WithId(R.id.navigation_test2)
    public InstrumentedView test2;

    @WithId(R.id.navigation_test3)
    public InstrumentedView test3;

    public MainPageObject() {
        PageObjectBinder.bind(this);
    }
}