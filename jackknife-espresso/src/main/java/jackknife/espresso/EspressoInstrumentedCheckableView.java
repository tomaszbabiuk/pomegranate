package jackknife.espresso;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.remote.annotation.RemoteMsgConstructor;
import android.view.View;
import android.widget.Checkable;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import jackknife.pageobject.InstrumentedCheckableView;

class EspressoInstrumentedCheckableView extends EspressoInstrumentedTextView implements InstrumentedCheckableView {

    public EspressoInstrumentedCheckableView(final ViewInteraction viewInteraction) {
        super(viewInteraction);
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

    @Override
    public void setChecked(final boolean checked) {
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

    @Override
    public boolean isChecked() {
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

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}
