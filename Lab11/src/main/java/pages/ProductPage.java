package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.Browser;

public class ProductPage extends AbstractPage {
    private static final String PRODUCT_PAGE = "testdata.packman.url";

    @FindBy(xpath = "//button[@data-test='add-to-bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@data-test='add-to-bag-modal']")
    private WebElement addedProductMessage;

    public ProductPage openPage() {
        Browser.getDriver().get(PRODUCT_PAGE);
        return this;
    }

    public ProductPage clickAddToBagButton() {
        addToBagButton.click();
        return this;
    }


}
