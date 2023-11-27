import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegoMainPage extends AbstractPage {
    private static final String legoMainPAgeURL = "https://www.lego.com/en-us";

    @FindBy(xpath = "//button[@data-test='search-input-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement inputField;

    public LegoMainPage(WebDriver driver) {
        super(driver);
    }

    public LegoMainPage openPageMain() {
        driver.get(legoMainPAgeURL);
        return this;
    }

    public LegoMainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public LegoMainPage enterDataIntoSearchField(String inputData) {
        inputField.sendKeys(inputData);
        return this;
    }

    public SearchResultPage submitInputData() {
        inputField.submit();
        return new SearchResultPage(driver);
    }

}
