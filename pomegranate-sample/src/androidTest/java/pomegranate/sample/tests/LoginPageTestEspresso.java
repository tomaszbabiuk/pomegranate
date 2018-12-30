package pomegranate.sample.tests;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pomegranate.sample.LoginActivity;
import pomegranate.sample.pageobjects.LoginPageObjectEspresso;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginPageTestEspresso {

    private final ActivityTestRule<LoginActivity> loginActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    private static final Intent ACTIVITY_INTENT =
            new Intent(InstrumentationRegistry.getTargetContext(), LoginActivity.class);

    @Before
    public void setup() {
        loginActivityTestRule.launchActivity(ACTIVITY_INTENT);
    }

    @Test
    public void userCanLoginWithoutAppCrash() {
        LoginPageObjectEspresso mainPage = new LoginPageObjectEspresso();
        mainPage.typeFirstName("pommer");
        mainPage.typeLastName("granator");
        mainPage.setTermsCheck(true);
        mainPage.clickLogin();

        //TODO: continue test
    }
}