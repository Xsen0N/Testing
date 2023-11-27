import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LegoTest {
    WebDriver driver = null;
    private static String inputData = "Harry Potter";

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\tools\\driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Test site navigation using searchbar")
    public void testSearchbar() {
        LegoMainPage legoMainPage = new LegoMainPage(driver);
        legoMainPage.openPageMain()
                .clickSearchButton()
                .enterDataIntoSearchField(inputData)
                .submitInputData()
                .getURL();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lego.com/en-us/search?q=Harry+Potter", "The problem lies in navigation");
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
        driver.quit();
        driver = null;
    }

}
