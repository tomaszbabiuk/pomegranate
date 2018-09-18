package poi.tb.sample.pageobject;

import jackknife.annotations.WithId;
import poi.tb.generated.PageObjectBinder;
import jackknife.pageobject.ClickPerformer;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;
import static android.support.test.espresso.Espresso.onView;

public class MainPageObject2 extends PageObject {

    @WithId(R.id.navigation_test1)
    public ClickPerformer<Test1PageObject> test1;

    @WithId(R.id.navigation_test1)
    public ClickPerformer<Test2PageObject> test2;

    @WithId(R.id.navigation_test1)
    public ClickPerformer<Test3PageObject> test3;

    public MainPageObject2() {
        PageObjectBinder.bind(this);
        onView(withId(R.id.container))
                .check(matches(notNullValue()))
                .check(matches(isDisplayed()));
    }
}