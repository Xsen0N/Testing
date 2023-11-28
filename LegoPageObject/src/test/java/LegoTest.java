import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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

    @Test(description = "Test to find lego instruction by date")
    public void findInstructionTest() {
        InstructionPage instructionPage = new InstructionPage(driver);
        instructionPage.openPage()
                .chooseFilterValue();
        Assert.assertTrue(driver.getCurrentUrl().contains("2022"), "Problem with year filter");
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.quit();
        driver = null;
    }

}
