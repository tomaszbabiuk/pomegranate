package pomegranate.sample.pageobjects;

import android.widget.EditText;

import pomegranate.annotations.IsAssignableFrom;
import pomegranate.annotations.IsDescendantOfA;
import pomegranate.espresso.EspressoInstrumentedTextView;
import pomegranate.generated.PageObjectBinder;
import pomegranate.pageobject.InstrumentedTextView;
import pomegranate.pageobject.PageObject;
import pomegranate.sample.R;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class LoginPageObjectWithCustomMatchers extends PageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedTextView firstName;

    //this instrumented view will be created manually
    public InstrumentedTextView lastName;

    public LoginPageObjectWithCustomMatchers() {
        //first let's jack-knife do it's magic
        PageObjectBinder.bind(this);

        //and now, let's add custom binding
        lastName = new EspressoInstrumentedTextView(onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.last_name_input))
        )));
    }
}