package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Browser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class MainPage extends AbstractPage {
    private static final String LEGO_MAIN_PAGE_URL = "testdata.main.page.url";


    @FindBy(xpath = "//button[@data-test='search-input-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement inputField;

    @FindBy(xpath = "//button[@id='blt51f52bea34c3fb01_menubutton']")
    private WebElement shopMenuButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[@class='Searchstyles__SearchButton-qaapd1-5 fIcfjG']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@data-test='region-selector-button']")
    private WebElement locationButton;

    @FindBy(xpath = "//a[@data-test='facebook-icon-link']")
    private WebElement socialSiteLink;

    @FindBy(xpath = "//button[@data-test='util-bar-wishlist']")
    private WebElement wishButton;

    public MainPage openPage() {
        Browser.getDriver().get(LEGO_MAIN_PAGE_URL);
        return this;
    }

    public MainPage clickSearchButton() {
        new WebDriverWait(Browser.getDriver(), 10);
        searchButton.click();
        return this;
    }

    public MainPage clickMainNavigationBarShopButton() {
        shopMenuButton.click();
        return this;
    }

    public MainPage clickWishButton() {
        wishButton.click();
        return this;
    }

    public MainPage enterDataInEmailInputField(String inputData) {
        emailInputField.sendKeys(inputData);
        return this;
    }

    public MainPage clickLocationButton() {
        locationButton.click();
        return this;
    }

    public MainPage clickSocialSiteLink() {
        socialSiteLink.click();
        Browser.getDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        return this;
    }

    public MainPage enterDataIntoSearchField(String inputData) {
        inputField.sendKeys(inputData);
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(emailInputField));
        return this;
    }

    public SearchResultPage submitInputData() {
        new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(emailInputField));
        submitButton.click();
        return new SearchResultPage();
    }

    public NewsPage chooseFieldInShopOption() {
        shopMenuButton.click();
        return new NewsPage();
    }


}
