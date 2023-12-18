
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.MainPage;
import webDriver.Browser;

public class BaseTest {
    MainPage mainPage = null;

    @BeforeMethod
    public void init() {
        Browser.initDriver();
        mainPage = new MainPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
        Browser.close();
    }
}
