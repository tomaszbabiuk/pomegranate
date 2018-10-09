package poi.tb.sample.test;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import jackknife.core.InstrumentationContextResolver;
import jackknife.espresso.EspressoInstrumentationContext;
import poi.tb.sample.LoginActivity;
import poi.tb.sample.pageobject.LoginPageObject;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginPageTest {

    private final ActivityTestRule<LoginActivity> loginActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    private static final Intent ACTIVITY_INTENT =
            new Intent(InstrumentationRegistry.getTargetContext(), LoginActivity.class);

    @Before
    public void setup() {
        InstrumentationContextResolver.set(new EspressoInstrumentationContext(InstrumentationRegistry.getTargetContext()));
        loginActivityTestRule.launchActivity(ACTIVITY_INTENT);
    }

    @Test
    public void userCanLoginWithoutAppCrash() {
        LoginPageObject mainPage = new LoginPageObject();
        mainPage.firstName.typeText("jacky");
        mainPage.lastName.typeText("knifey");
        mainPage.termsAndConditionsCheck.setChecked(true);
        mainPage.login.click();
    }
}
