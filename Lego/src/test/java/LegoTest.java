import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class LegoTest {
    WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\tools\\driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Test site navigation")
    public void testSiteNavigation() throws InterruptedException {
        driver.get("https://www.lego.com/en-us");
        WebElement navigationButton = setWebElement(By.xpath("//button[@id='blt51f52bea34c3fb01_menubutton']"));
        navigationButton.click();
        WebElement newProducts = setWebElement(By.xpath("//a[@data-analytics-title='new']"));
        newProducts.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lego.com/en-us/categories/new-sets-and-products", "The problem lies in navigation");
    }

    @Test(description = "Test site navigation using searchbar ")
    public void searchbarTest() throws InterruptedException {
        driver.get("https://www.lego.com/en-us");
        WebElement navigationButton = setWebElement(By.xpath("//button[@data-test='search-input-button']"));
        navigationButton.click();
        WebElement inputFile = setWebElement(By.xpath("//input[@name='search']"));
        inputFile.sendKeys("Harry Potter");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        inputFile.submit();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lego.com/en-us/search?q=Harry+Potter", "The problem lies in navigation");
    }

    @DataProvider(name = "testEmails")
    public Object[][] createIncorrectEmail() {
        return new Object[][]{
                {new String("user@.com")},
                {new String("йййй@ййй.ййй ")},
                {new String("   ")},
                {new String("user@..com ")},
                {new String("user@domain.")},
        };
    }

    @Test(dataProvider = "testEmails", description = "Test incorrect emails")
    public void testIncorrectEmails(String email) {
        driver.get("https://www.lego.com/en-us");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchBar = setWebElement(By.xpath("//input[@type='text']"));
        searchBar.sendKeys(email);
        WebElement submitButton = setWebElement(By.xpath("//button[@kind='submit']"));
        submitButton.click();
        List<WebElement> errorMessage = driver.findElements(By.xpath("//span[@class='EmailSubscriptionstyles__InputError-sc-48ulj8-4 fTURKp']"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Assert.assertFalse(errorMessage.isEmpty(), "Should be error message!");
    }

    @Test(description = "Test adding product to the bag")
    public void addToBagTest() throws InterruptedException {
        driver.get("https://www.lego.com/en-us/product/pac-man-arcade-10323");
        driver.manage().window().fullscreen();
        WebElement addButton = setWebElement(By.xpath("//button[@data-test='add-to-bag']"));
        addButton.click();
        List<WebElement> productSuccessfullyAddedMessage = driver.findElements(By.xpath("//div[@data-test='add-to-bag-modal']"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Thread.sleep(2000);
        Assert.assertFalse(!productSuccessfullyAddedMessage.isEmpty(), "Should be message that product was successfully added!");
    }

    @Test(description = "Find instruction by name")
    public void sortCommentsTest() {
        driver.get("https://www.lego.com/en-us/service/buildinginstructions");
        WebElement searchbarInstruction = setWebElementLocation(By.xpath("//input[@data-cy='search-bar-input']"));
        searchbarInstruction.sendKeys("Harry Potter");
        WebElement findButton = setWebElement(By.xpath("//button[@aria-label='Search']"));
        findButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lego.com/en-us/service/buildinginstructions/search?q=Harry%20Potter", "Problems with query processing" );
    }

    @Test(description = "User should can open social sites links")
    public void testSocialSitesLinks() {
        driver.get("https://www.lego.com/en-us");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement testButton = setWebElement(By.xpath("//a[@data-test='facebook-icon-link']"));
        testButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/LEGO/", "Url is not correct");
    }

    @Test(description = "Test to find lego instruction by date")
    public void findInstructionTest() {
        driver.get("https://www.lego.com/en-us/service/buildinginstructions");
        WebElement yearFilter = setWebElement(By.xpath("//option[@value='2022']"));
        yearFilter.click();
        WebElement yearValue = setWebElementLocation(By.xpath("//div[@class='c-form-item__control c-form-item__control--filled']"));
        Assert.assertEquals(yearValue.getText(), "2022", "Problem with year filter");
    }

    @Test(description = "Test how site can correct delete all cookies")
    public void testDeleteCookies() {
        driver.get("https://www.lego.com/en-us");
        driver.manage().deleteAllCookies();
        Assert.assertEquals(driver.manage().getCookies().size(), 0, "Problems with cookies");
    }

    @Test(description = "Test changing location page")
    public void testChangeLocation(){
        driver.get("https://www.lego.com/en-us");
        WebElement regionChangingButton = setWebElement(By.xpath("//button[@data-test='region-selector-button']"));
        regionChangingButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebElement regionButton = setWebElement(By.xpath("//h2[@class='Text__BaseText-sc-13i1y3k-0 zkrlj sharedstyles__StyledText-ubbvf-1 cKJJpA']"));
        Assert.assertEquals(regionButton.getText(), "Choose Your Country or Region", "Problem with user redirection");
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
        driver.quit();
        driver = null;
    }

    private WebElement setWebElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement setWebElementLocation(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
