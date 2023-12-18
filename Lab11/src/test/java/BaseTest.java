
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.MainPage;
import webDriver.Browser;

import java.util.Set;
import java.util.stream.Collectors;

public class BaseTest {
    MainPage mainPage = null;

    @BeforeMethod
    public void init() {
        Browser.initDriver();
        mainPage = new MainPage();
    }

    @AfterMethod(alwaysRun = true, dependsOnMethods = "printLogs")
    public void closePage() {
        Browser.close();
    }

    @AfterMethod
    public void printLogs() {
        Set<String> logs = Browser.getDriver().manage().logs().get("browser").getAll().stream()
                .map(LogEntry::getMessage).collect(Collectors.toSet());
        logs.forEach(System.out::println);

    }
}
