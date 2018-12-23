package pomegranate.sample.tests;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pomegranate.sample.pageobjects.LoginPageObjectPOMgranate;
import pomegranate.core.InstrumentationContextResolver;
import pomegranate.espresso.EspressoInstrumentationContext;
import pomegranate.sample.LoginActivity;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginPageTestPOMegranate {

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
        LoginPageObjectPOMgranate mainPage = new LoginPageObjectPOMgranate();
        mainPage.firstName.typeText("pommer");
        mainPage.lastName.typeText("granator");
        mainPage.termsAndConditionsCheck.setChecked(true);
        mainPage.login.assertIsDisplayed();
    }
}