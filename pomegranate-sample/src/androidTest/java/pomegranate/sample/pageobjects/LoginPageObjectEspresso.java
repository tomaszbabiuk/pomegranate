package pomegranate.sample.pageobjects;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.remote.annotation.RemoteMsgConstructor;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import pomegranate.sample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class LoginPageObjectEspresso {

    public void typeFirstName(String firstName) {
        ViewInteraction firstNameInteraction = locateFirstName();
        firstNameInteraction.perform(ViewActions.typeText(firstName));
    }

    public String getFirstName() {
        ViewInteraction firstNameInteraction = locateFirstName();
        return getTextFromView(firstNameInteraction);
    }

    public void typeLastName(String lastName) {
        ViewInteraction lastNameInteraction = locateLastName();
        lastNameInteraction.perform(ViewActions.typeText(lastName));
    }

    public String getLastName() {
        ViewInteraction lastNameInteraction = locateLastName();
        return getTextFromView(lastNameInteraction);
    }

    public void setTermsCheck(boolean checked) {
        ViewInteraction checkTermsInteraction = locateTermsCheckbox();
        setChecked(checked, checkTermsInteraction);
    }

    public boolean isTermsChecked() {
        ViewInteraction checkTermsInteraction = locateTermsCheckbox();
        return isChecked(checkTermsInteraction);
    }

    public void clickLogin() {
        ViewInteraction loginButtonInteraction = locateLoginButton();
        loginButtonInteraction.perform(click());
    }

    private ViewInteraction locateFirstName() {
        return onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.first_name_input))));
    }

    private ViewInteraction locateLastName() {
        return onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.last_name_input))));
    }

    private ViewInteraction locateTermsCheckbox() {
        return onView(withId(R.id.terms_and_conditions_check));
    }

    private ViewInteraction locateLoginButton() {
        return onView(withId(R.id.login_button));
    }

    private String getTextFromView(ViewInteraction viewInteraction) {
        final String[] stringHolder = {null};
        viewInteraction.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

    private void setChecked(final boolean checked, ViewInteraction viewInteraction) {
        viewInteraction.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return new WithCheckBoxStateMatcher<>();
            }

            @Override
            public String getDescription() {
                return "checking";
            }

            @Override
            public void perform(UiController uiController, View view) {
                Checkable checkable = (Checkable) view;
                checkable.setChecked(checked);
            }
        });
    }

    private boolean isChecked(ViewInteraction viewInteraction) {
        final boolean[] checked = {false};
        viewInteraction.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return new WithCheckBoxStateMatcher<>();
            }

            @Override
            public String getDescription() {
                return "checking checked state";
            }

            @Override
            public void perform(UiController uiController, View view) {
                Checkable checkable = (Checkable) view;
                checked[0] = checkable.isChecked();
            }
        });

        return checked[0];
    }

    static final class WithCheckBoxStateMatcher<E extends View & Checkable>
            extends BoundedMatcher<View, E> {
        @RemoteMsgConstructor
        private WithCheckBoxStateMatcher() {
            super(View.class, Checkable.class);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("with checkbox state: ");
        }

        @Override
        public boolean matchesSafely(E checkable) {
            return true;
        }
    }
}