package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.WithId;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class LoginPageObject extends PageObject {

    @IsAssignableFrom(EditText.class)
    @WithId(R.id.first_name_input)
    public InstrumentedTextView firstName;

    @IsAssignableFrom(EditText.class)
    @WithId(R.id.last_name_input)
    public InstrumentedTextView lastName;

    @WithId(R.id.terms_and_conditions_check)
    public InstrumentedView termsAndConditions;

    @WithId(R.id.login_button)
    public InstrumentedView login;

    public LoginPageObject() {
        PageObjectBinder.bind(this);
    }

}