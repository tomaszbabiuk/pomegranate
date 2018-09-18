package poi.tb.sample.pageobject;

import jackknife.annotations.WithId;
import poi.tb.generated.PageObjectBinder;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class MainPageObject extends PageObject {

    @WithId(R.id.navigation_test1)
    public ClickPerformer<Test1PageObject> test1;

    @WithId(R.id.navigation_test2)
    public ClickPerformer<Test2PageObject> test2;

    @WithId(R.id.navigation_test3)
    public ClickPerformer<Test3PageObject> test3;

    public MainPageObject() {
        PageObjectBinder.bind(this);
    }
}