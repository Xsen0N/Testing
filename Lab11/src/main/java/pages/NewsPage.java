package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Browser;

import java.time.Duration;
import java.util.concurrent.locks.Condition;

public class NewsPage extends AbstractPage {
    @FindBy(xpath = "//h1[@data-test='inpagenav-title']")
    public WebElement mainHeader;


    public NewsPage getURL() {
        new WebDriverWait(Browser.getDriver(), 30).until(ExpectedConditions.urlToBe("https://www.lego.com/en-us/categories/new-sets-and-products"));
        return this;
    }

    public NewsPage waitHeaderOnThePage() {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> mainHeader.isDisplayed());
        mainHeader.click();
        return this;
    }
}
