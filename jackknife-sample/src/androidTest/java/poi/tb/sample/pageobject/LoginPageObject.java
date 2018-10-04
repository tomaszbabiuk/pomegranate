package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.WithId;
import jackknife.annotations.WithParentIdAndClass;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class LoginPageObject extends PageObject {

    @WithParentIdAndClass(value = R.id.first_name_input, clazz = EditText.class)
    public InstrumentedTextView firstName;

    @WithParentIdAndClass(value = R.id.last_name_input, clazz = EditText.class)
    public InstrumentedTextView lastName;

    @WithId(R.id.terms_and_conditions_check)
    public InstrumentedView termsAndConditions;

    @WithId(R.id.login_button)
    public InstrumentedView login;

    public LoginPageObject() {
        PageObjectBinder.bind(this);
    }

}