# Using custom matchers
Using custom matchers can be really helpful in cases when jackknife annotation is not enough.
Example:
```java
public class LoginPageObjectWithCustomMatchers extends PageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedTextView firstName;
    
    public InstrumentedTextView lastName;

    public CustomLoginPageObject() {
        //let jack-knife do it's magic
        PageObjectBinder.bind(this);
        
        //and let's use some 
        lastName = new EspressoInstrumentedTextView(onView(allOf(
                isAssignableFrom(EditText.class), isDescendantOfA(withId(R.id.last_name_input))
        )));
    }
}
```