package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.IsDescendantOfA;
import jackknife.annotations.WithAlpha;
import jackknife.annotations.WithContentDescription;
import jackknife.annotations.WithId;
import jackknife.annotations.WithTagKey;
import jackknife.annotations.WithText;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;
import jackknife.pageobject.PageObject;
import poi.tb.sample.R;

public class LoginPageObject extends PageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedTextView firstName;

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.last_name_input)
    public InstrumentedTextView lastName;

    @WithTagKey(R.id.checkable)
    public InstrumentedView termsAndConditionsCheck;

    @WithText(fromResource = R.string.login)
    @WithAlpha(0.1f)
    @WithContentDescription("aaaa")
    public InstrumentedView login;

    public LoginPageObject() {
        PageObjectBinder.bind(this);
    }

}