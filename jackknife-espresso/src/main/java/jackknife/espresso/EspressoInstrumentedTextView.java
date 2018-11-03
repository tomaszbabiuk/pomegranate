package jackknife.espresso;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;

import jackknife.pageobject.InstrumentedTextView;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

public class EspressoInstrumentedTextView extends EspressoInstrumentedView implements InstrumentedTextView {

    public EspressoInstrumentedTextView(final ViewInteraction viewInteraction) {
        super(viewInteraction);
    }


    @Override
    public String getText() {
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
}
