package poi.tb.sample.test;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import poi.tb.core.InstrumentationContext;
import poi.tb.core.InstrumentationContextNotCreatedException;
import poi.tb.core.InstrumentationContextResolver;
import poi.tb.sample.MainActivity;
import poi.tb.sample.R;
import poi.tb.sample.pageobject.EspressoInstrumentationContext;
import poi.tb.sample.pageobject.MainPageObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainPageTest {

    private final ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private static final Intent ACTIVITY_INTENT =
            new Intent(InstrumentationRegistry.getTargetContext(), MainActivity.class);

    @Before
    public void setup() {
        InstrumentationContextResolver.set(new EspressoInstrumentationContext());
        mainActivityTestRule.launchActivity(ACTIVITY_INTENT);
    }

    @Test
    public void canChangeTabsWithoutCrashingAppTest() throws Exception, InstrumentationContextNotCreatedException {
        MainPageObject mainPage = new MainPageObject();

        mainPage.test1.click();
        mainPage.test2.click();
        mainPage.test3.click();
    }
}
