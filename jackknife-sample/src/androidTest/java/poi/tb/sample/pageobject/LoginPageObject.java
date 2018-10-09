package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.IsDescendantOfA;
import jackknife.annotations.WithId;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedCheckableView;
import jackknife.pageobject.InstrumentedEditView;
import jackknife.pageobject.InstrumentedView;
import poi.tb.sample.R;

public class LoginPageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedEditView firstName;

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.last_name_input)
    public InstrumentedEditView lastName;

    @WithId(R.id.terms_and_conditions_check)
    public InstrumentedCheckableView termsAndConditionsCheck;

    @WithId(R.id.login_button)
    public InstrumentedView login;

    public LoginPageObject() {
        PageObjectBinder.bind(this);
    }
}