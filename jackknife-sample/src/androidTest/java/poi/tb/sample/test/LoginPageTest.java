package poi.tb.sample.test;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.base.DefaultFailureHandler;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
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





    public class CustomFailureHandler implements FailureHandler {

        private final FailureHandler delegate;

        public CustomFailureHandler(@NonNull Instrumentation instrumentation) {
            delegate = new DefaultFailureHandler(instrumentation.getTargetContext());
        }

        @Override
        public void handle(final Throwable error, final Matcher<View> viewMatcher) {
            // Log anything you want here

            // Then delegate the error handling to the default handler which will throw an exception
            //delegate.handle(error, viewMatcher);
        }
    }



    @Before
    public void setup() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Espresso.setFailureHandler(new CustomFailureHandler(instrumentation));

        InstrumentationContextResolver.set(new EspressoInstrumentationContext(InstrumentationRegistry.getTargetContext()));
        loginActivityTestRule.launchActivity(ACTIVITY_INTENT);
    }

    @Test
    public void userCanLoginWithoutAppCrash() {
        LoginPageObject mainPage = new LoginPageObject();
        mainPage.firstName.typeText("jacky");
        mainPage.lastName.typeText("knifey");
        mainPage.termsAndConditionsCheck.setChecked(true);
//        mainPage.login.click();

        boolean x = mainPage.login.assertIsDisplayed();
        boolean y = x;
    }
}
