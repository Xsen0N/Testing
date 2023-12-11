import enums.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.MainPage;
import webDriver.Browser;

public class BaseTest {
    @BeforeSuite
    public void init() {
        Browser.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
        Browser.close();
    }
}
