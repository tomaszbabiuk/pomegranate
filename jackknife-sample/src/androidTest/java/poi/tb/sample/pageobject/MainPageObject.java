package poi.tb.sample.pageobject;

import poi.tb.annotations.WithId;
import poi.tb.generated.PageObjectBinder;
import poi.tb.pageobject.ClickPerformer;
import poi.tb.pageobject.PageObject;
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