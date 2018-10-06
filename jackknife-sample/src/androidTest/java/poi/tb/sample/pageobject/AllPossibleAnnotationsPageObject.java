package poi.tb.sample.pageobject;

import android.widget.EditText;

import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.IsDescendantOfA;
import jackknife.annotations.Visibility;
import jackknife.annotations.WithAlpha;
import jackknife.annotations.WithContentDescription;
import jackknife.annotations.WithEffectiveVisibility;
import jackknife.annotations.WithHint;
import jackknife.annotations.WithId;
import jackknife.annotations.WithTagKey;
import jackknife.annotations.WithText;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedView;
import poi.tb.sample.R;

public class AllPossibleAnnotationsPageObject {
    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.login_button)
    @WithAlpha(0.1f)
    @WithContentDescription("aaaa")
    @WithId(R.id.login_button)
    @WithEffectiveVisibility(Visibility.Gone)
    @WithHint("Login")
    @WithTagKey(R.id.checkable)
    @WithText("Login")
    public InstrumentedView mishmash1;



    @WithText(fromResource = R.string.login)
    @WithHint(fromResource = R.string.login)
    @WithContentDescription(fromResource = R.string.login)
    public InstrumentedView mishmash2;

    public AllPossibleAnnotationsPageObject() {
        PageObjectBinder.bind(this);
    }

}