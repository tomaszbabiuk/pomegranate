# POMegranate
POMegranate is Page Object injection framework for android automation tests. The goal of the framework is to reduce boilerplate code related with POM models.

# The idea
If you write android UI automation tests you probably think of Espresso framework. Probably you even heard of Page Object Model pattern which helps you with reusing some of the code across your tests. But writing Page Objects is not always a pleasant task. It’s time consuming and you need to be really precise to achieve your goal. POMegranate framework can help you in this tasks. 

The inspiration for this framework comes from two projects: Selenium tools for web and ButterKnife framework for Android. POMegranate combines both: boilerplate reduction and code generation.

POMegranate is using annotation processor to generate it's code when you build/run your tests. No reflection is used! Generated code is clean and self-describing.

# How to use?
Add pomegranate repository to your project's gradle file
```groovy
repositories {
    maven { url "https://dl.bintray.com/tomaszbabiuk/pomegranate" }
}
```

And use pomegranate packets:
```groovy
    androidTestImplementation 'com.github.tomaszbabiuk:pomegranate-core:0.1.0'
    androidTestImplementation 'com.github.tomaszbabiuk:pomegranate-espresso:0.1.0'
    androidTestAnnotationProcessor 'com.github.tomaszbabiuk:pomegranate-processor:0.1.0'
```

# Sample Page Object Model with POMegranate
Here's how your Page Objects can look if you decide to use POMegranate:

```java
public class LoginPageObject {

    @IsAssignableFrom(EditText.class)
     @IsDescendantOfA(R.id.first_name_input)
     public InstrumentedTextView firstName;
 
     @IsAssignableFrom(EditText.class)
     @IsDescendantOfA(R.id.last_name_input)
     public InstrumentedTextView lastName;
 
     @WithId(R.id.terms_and_conditions_check)
     public InstrumentedView termsAndConditionsCheck;
 
     @WithId(R.id.login_button)
     public InstrumentedView login;
 
     public LoginPageObject() {
         PageObjectBinder.bind(this);
     }
 }
```

And now your automation test can quickly use POM from previous step. You don't even need to know espresso to write simple automation tests.
```java
    @Test
    public void userCanLoginWithoutAppCrash() {
        LoginPageObject mainPage = new LoginPageObject();
        mainPage.firstName.typeText("pommer");
        mainPage.lastName.typeText("granate");
        mainPage.termsAndConditionsCheck.click();
        mainPage.login.click();
    }
```

Remember PageObjectBinder object won't be generated until you run your test (that's when annotation processors for androidTest are called).

# How much code POMgranate will generate for you?
Let's look how much boilerplate has been generated for you by POMegranate. Now imagine that's the only one POM in your project!
```java
public class PageObjectBinder {
  public static void bind(LoginPageObject target) {
    InstrumentationContext instrumentationContext = InstrumentationContextResolver.resolve();
    // Bindings for "lastName"
    InstrumentationBuilder lastNameBuilder = instrumentationContext.createBuilder();
    lastNameBuilder.appendIsAssignableFromMatcher(EditText.class);
    lastNameBuilder.appendIsDescendantOfMatcher(2131230811);
    target.lastName = lastNameBuilder.build(InstrumentedTextView.class);

    // Bindings for "login"
    InstrumentationBuilder loginBuilder = instrumentationContext.createBuilder();
    loginBuilder.appendWithIdMatcher(2131230817);
    target.login = loginBuilder.build(InstrumentedView.class);

    // Bindings for "firstName"
    InstrumentationBuilder firstNameBuilder = instrumentationContext.createBuilder();
    firstNameBuilder.appendIsAssignableFromMatcher(EditText.class);
    firstNameBuilder.appendIsDescendantOfMatcher(2131230794);
    target.firstName = firstNameBuilder.build(InstrumentedTextView.class);

    // Bindings for "termsAndConditionsCheck"
    InstrumentationBuilder termsAndConditionsCheckBuilder = instrumentationContext.createBuilder();
    termsAndConditionsCheckBuilder.appendWithIdMatcher(2131230886);
    target.termsAndConditionsCheck = termsAndConditionsCheckBuilder.build(InstrumentedView.class);

  }
}
```

# Limitations
POMegranate uses annotations. Only declarative matchers are supported. That suits 90% percent of your code. You can always mix espresso with POMegranate, see [compatibility table](compatibility-table.md).

# Mixing code with Espresso
Sometimes, the annotations from  [compatibility table](compatibility-table.md) are not enough. It's not the end of the world. You can still mix espresso in your page object model:
```java
public class LoginPageObjectWithCustomMatchers extends PageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedTextView firstName;

    //this instrumented view will be created by our matcher
    public InstrumentedTextView lastName;

    public LoginPageObjectWithCustomMatchers() {
        //first let's jack-knife do it's magic
        PageObjectBinder.bind(this);

        //and now, let's add custom binding
        lastName = new EspressoInstrumentedTextView(onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.last_name_input))
        )));
    }
}
```

If you use EspressoInstrumentedTextView instead of IntrumentedTextView...
```java
(...)
    //this instrumented view will be created by our matcher
    public EspressoInstrumentedTextView lastName;
(...)
}
```
...you'll be able to call espresso methods directly:
```java
public class LoginPageObjectWithCustomMatchers extends PageObject {

    @IsAssignableFrom(EditText.class)
    @IsDescendantOfA(R.id.first_name_input)
    public InstrumentedTextView firstName;

    //this instrumented view will be created in the constructor
    public EspressoInstrumentedTextView lastName;

    public LoginPageObjectWithCustomMatchers() {
        //first let's pomegranate do it's magic
        PageObjectBinder.bind(this);

        //and now, let's add custom binding
        lastName = new EspressoInstrumentedTextView(onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.last_name_input))
        )));
    }

    public void performCustomActionOnLastName() {
        lastName.performCustom(/* your custom ViewActions goes here */);
    }

    public void performCustomAssertion() {
        lastName.assertCustom(/* your custom ViewAssertion goes here */);
    }
}
```