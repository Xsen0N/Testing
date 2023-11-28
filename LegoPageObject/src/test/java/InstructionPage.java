import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstructionPage extends AbstractPage {
    private static final String instructionPage = "https://www.lego.com/en-us/service/buildinginstructions";

    @FindBy(xpath = "//option[@value='2022']")
    private WebElement yearFilter;

    public InstructionPage(WebDriver driver) {
        super(driver);
    }

    public InstructionPage openPage() {
        driver.get(instructionPage);
        return this;
    }
    public InstructionPage chooseFilterValue() {
        yearFilter.click();
        return this;
    }


}
