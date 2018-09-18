# jack-knife
JackKnife is Page Object injection framework for android automation tests. It's like popular ButterKnife but for POMs (Page Object Models).

If you write android UI automation tests you probably think of Espresso framework. Probably you even heard of Page Object Model pattern which helps you reuse some of the code across your tests. But writing Page Objects is not always a pleasant task. It’s time consuming and you need to be really precise to achieve your goal. This article is about Jack-knife framework which helps you in this tasks. It’s like a popular ButterKnife but insted of injecting views it injects block from which your Page Objects are built.

# traditional page object (for the purpose of Espresso framework)
`public class MainPageObject extends PageObject {

    public Test1PageObject clickTest1() {
      performClick(R.id.navigation_test1);
      return reuseModel(Test1PageObject.class);
    }

    public Test2PageObject clickTest2() {
      performClick(R.id.navigation_test2);
      return reuseModel(Test1PageObject.class);
    }
    
    public Test3PageObject clickTest3() {
      performClick(R.id.navigation_test3);
      return reuseModel(Test1PageObject.class);
    }

    public MainPageObject() {
      //make sure your POMs factory is initialized... etc...
    }
    
    private void performClick() {
        onView(withId(buttonId)).perform(click());
    }
    
    private <T extends PageObject> T reuseModel(Class<T> classOfPomToReuse) {
        return Factory.reuse(nextPageObjectType
    }
}'

    @Test
    public void canChangeTabsWithoutCrashingAppTest() {
        MainPageObject mainPage = new MainPageObject();

        mainPage.clickTest1();
        mainPage.clickTest2();
        mainPage.clickTest3();
    }

# same functionality here with reduced boilerplate
`
public class MainPageObject extends PageObject {

    @WithId(R.id.navigation_test1)
    public ClickPerformer<Test1PageObject> test1;

    @WithId(R.id.navigation_test2)
    public ClickPerformer<Test2PageObject> test2;

    @WithId(R.id.navigation_test3)
    public ClickPerformer<Test3PageObject> test3;

    public MainPageObject() {
        PageObjectBinder.bind(this);
    }
}
`



`
    @Test
    public void canChangeTabsWithoutCrashingAppTest() throws Exception, InstrumentationContextNotCreatedException {
        MainPageObject mainPage = new MainPageObject();

        mainPage.test1.click();
        mainPage.test2.click();
        mainPage.test3.click();
    }
`
