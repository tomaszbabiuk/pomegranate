package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.IsDescendantOfA;
import jackknife.annotations.Visibility;
import jackknife.annotations.WithAlpha;
import jackknife.annotations.WithContentDescription;
import jackknife.annotations.WithEffectiveVisibility;
import jackknife.annotations.WithTagKey;
import jackknife.annotations.WithText;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedTextView;
import jackknife.pageobject.InstrumentedView;
import poi.tb.sample.R;

public class AllPossibleAnnotationsPageObject {

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
    @WithEffectiveVisibility(Visibility.Gone)
    public InstrumentedView mishmash;

    public AllPossibleAnnotationsPageObject() {
        PageObjectBinder.bind(this);
    }

}