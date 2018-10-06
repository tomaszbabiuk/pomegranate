package poi.tb.sample.pageobject;

import android.text.InputType;
import android.widget.EditText;

import jackknife.annotations.HasBackground;
import jackknife.annotations.HasChildCount;
import jackknife.annotations.HasContentDescription;
import jackknife.annotations.HasErrorText;
import jackknife.annotations.HasFocus;
import jackknife.annotations.HasLinks;
import jackknife.annotations.IsAssignableFrom;
import jackknife.annotations.IsChecked;
import jackknife.annotations.IsClickable;
import jackknife.annotations.IsCompletelyDisplayed;
import jackknife.annotations.IsDescendantOfA;
import jackknife.annotations.IsDisplayed;
import jackknife.annotations.IsDisplayingAtLeast;
import jackknife.annotations.IsEnabled;
import jackknife.annotations.IsFocusable;
import jackknife.annotations.IsJavascriptEnabled;
import jackknife.annotations.IsNotChecked;
import jackknife.annotations.IsRoot;
import jackknife.annotations.IsSelected;
import jackknife.annotations.SupportsInputMethods;
import jackknife.annotations.Visibility;
import jackknife.annotations.WithAlpha;
import jackknife.annotations.WithContentDescription;
import jackknife.annotations.WithEffectiveVisibility;
import jackknife.annotations.WithHint;
import jackknife.annotations.WithId;
import jackknife.annotations.WithInputType;
import jackknife.annotations.WithParentIndex;
import jackknife.annotations.WithResourceName;
import jackknife.annotations.WithSpinnerText;
import jackknife.annotations.WithSubstring;
import jackknife.annotations.WithTagKey;
import jackknife.annotations.WithText;
import jackknife.generated.PageObjectBinder;
import jackknife.pageobject.InstrumentedView;
import poi.tb.sample.R;

public class MishMashPageObject {
    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.login_button)
    @WithAlpha(0.1f)
    @WithContentDescription("aaaa")
    @WithId(R.id.login_button)
    @WithEffectiveVisibility(Visibility.Gone)
    @WithHint("Login")
    @WithTagKey(R.id.checkable)
    @WithText("Login")
    @WithInputType(InputType.TYPE_CLASS_PHONE)
    @WithResourceName("res.name")
    @WithSpinnerText("spinnerText")
    @WithSubstring("aaaa")
    @WithParentIndex(1)
    @IsChecked()
    @IsDisplayed()
    @IsClickable()
    @IsCompletelyDisplayed()
    @IsDisplayingAtLeast(10)
    @IsEnabled()
    @IsFocusable()
    @IsJavascriptEnabled()
    @IsRoot()
    @IsSelected()
    @IsNotChecked()
    @HasBackground(R.drawable.ic_launcher_background)
    @HasChildCount(5)
    @HasContentDescription()
    @HasFocus()
    @HasLinks()
    @SupportsInputMethods()
    @HasErrorText("error")
    public InstrumentedView mishmash1;



    @WithText(fromResource = R.string.login)
    @WithHint(fromResource = R.string.login)
    @WithContentDescription(fromResource = R.string.login)
    @WithSpinnerText(fromResource = R.string.login)
    @HasErrorText(fromResource = R.string.login)
    public InstrumentedView mishmash2;

    public MishMashPageObject() {
        PageObjectBinder.bind(this);
    }

}