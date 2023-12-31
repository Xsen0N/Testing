package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Browser;


public class SearchResultPage extends AbstractPage {
    private static final String EXPECTED_URL_AFTER_SEARCH = "https://www.lego.com/en-us/search?q=Harry+Potter";

    public SearchResultPage getURL() {
        new WebDriverWait(Browser.getDriver(),10).until(ExpectedConditions.urlToBe(EXPECTED_URL_AFTER_SEARCH));
        return this;
    }
}
