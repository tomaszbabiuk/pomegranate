package pomegranate.sample.pageobjects;

import android.widget.EditText;

import pomegranate.annotations.IsAssignableFrom;
import pomegranate.annotations.IsDescendantOfA;
import pomegranate.annotations.WithId;
import pomegranate.espresso.EspressoInstrumentedView;
import pomegranate.generated.PageObjectBinder;
import pomegranate.pageobject.InstrumentedCheckableView;
import pomegranate.pageobject.InstrumentedEditView;
import pomegranate.sample.R;


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
    public EspressoInstrumentedView login;

    public LoginPageObject() {
        PageObjectBinder.bind(this);
    }
}