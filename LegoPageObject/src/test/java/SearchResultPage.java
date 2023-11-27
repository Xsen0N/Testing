import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.time.Duration;

public class SearchResultPage extends AbstractPage {
    private static final String expectedUrlAfterSearch = "https://www.lego.com/en-us/search?q=Harry+Potter";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage getURL() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.urlToBe(expectedUrlAfterSearch));
        return this;
    }
}
