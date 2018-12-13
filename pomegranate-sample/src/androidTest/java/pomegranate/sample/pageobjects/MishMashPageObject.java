package pomegranate.sample.pageobjects;

import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import poi.tb.sample.R;
import pomegranate.annotations.HasBackground;
import pomegranate.annotations.HasChildCount;
import pomegranate.annotations.HasContentDescription;
import pomegranate.annotations.HasErrorText;
import pomegranate.annotations.HasFocus;
import pomegranate.annotations.HasImeAction;
import pomegranate.annotations.HasLinks;
import pomegranate.annotations.HasMinimumChildCount;
import pomegranate.annotations.HasTextColor;
import pomegranate.annotations.IsAssignableFrom;
import pomegranate.annotations.IsChecked;
import pomegranate.annotations.IsClickable;
import pomegranate.annotations.IsCompletelyDisplayed;
import pomegranate.annotations.IsDescendantOfA;
import pomegranate.annotations.IsDisplayed;
import pomegranate.annotations.IsDisplayingAtLeast;
import pomegranate.annotations.IsEnabled;
import pomegranate.annotations.IsFocusable;
import pomegranate.annotations.IsJavascriptEnabled;
import pomegranate.annotations.IsNotChecked;
import pomegranate.annotations.IsRoot;
import pomegranate.annotations.IsSelected;
import pomegranate.annotations.SupportsInputMethods;
import pomegranate.annotations.Visibility;
import pomegranate.annotations.WithAlpha;
import pomegranate.annotations.WithContentDescription;
import pomegranate.annotations.WithEffectiveVisibility;
import pomegranate.annotations.WithHint;
import pomegranate.annotations.WithId;
import pomegranate.annotations.WithInputType;
import pomegranate.annotations.WithParentIndex;
import pomegranate.annotations.WithResourceName;
import pomegranate.annotations.WithSpinnerText;
import pomegranate.annotations.WithSubstring;
import pomegranate.annotations.WithTagKey;
import pomegranate.annotations.WithText;
import pomegranate.generated.PageObjectBinder;
import pomegranate.pageobject.InstrumentedView;

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
    @HasImeAction(EditorInfo.IME_ACTION_SEND)
    @HasMinimumChildCount(10)
    @HasTextColor(R.color.colorAccent)
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