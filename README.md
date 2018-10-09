# Jack-knife
JackKnife is Page Object injection framework for android automation tests. The goal of the framework is to reduce boilerplate code related with POM models.

# The idea
If you write android UI automation tests you probably think of Espresso framework. Probably you even heard of Page Object Model pattern which helps you with reusing some of the code across your tests. But writing Page Objects is not always a pleasant task. It’s time consuming and you need to be really precise to achieve your goal. Jack-knife framework can help you in this tasks. 

The inspiration for this framework comes from two projects: Selenium tools for web and ButterKnife framework for Android. Jack-knife combines both: boilerplate reduction and code generation.

Jack-Knife is using annotation processor to generate it's code when you build/run your tests. No reflection is used! Generated code is clean and self-describing.

# Sample Page Object Model with Jack-knife
Here's how your Page Objects can look if you decide to use jack-knife:

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
        mainPage.firstName.typeText("jacky");
        mainPage.lastName.typeText("knifey");
        mainPage.termsAndConditionsCheck.click();
        mainPage.login.click();
    }
```

# How much code you don't need to write?
Let's look how much boilerplate has been generated for you by jack-knife. Now imagine that's the only one POM in your project!
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
As jack-knife uses annotations only declarative matchers are supported. That suits 90% percent of your code. You can always mix espresso with jack-knife, see [compatibility table](compatibility-table.md).
