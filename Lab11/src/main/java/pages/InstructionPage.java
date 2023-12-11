package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.Browser;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class InstructionPage extends AbstractPage{
    protected final Logger logger = LogManager.getLogger(String.valueOf(InstructionPage.class));;
    private static final String INSTRUCTION_PAGE_URL = "testdata.instruction.page.url";

    @FindBy(xpath = "//option[@value='2022']")
    private WebElement yearFilter;

    @FindBy(xpath = "//input[@data-cy='search-bar-input']")
    private WebElement instructionSearchBarInput;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement instructionSearchBarSubmitButton;


    public InstructionPage openPage() {
        Browser.getDriver().get(INSTRUCTION_PAGE_URL);
        logger.info("");
        return this;
    }

    public InstructionPage chooseFilterValue() {
        yearFilter.click();
        return this;
    }
    public InstructionPage enterDataIntoSearchBar(String data) {
        instructionSearchBarInput.sendKeys(data);
        return this;
    }

    public InstructionPage submitInputData() {
        instructionSearchBarSubmitButton.click();
        return this;
    }



}