package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class InstructionPage extends AbstractPage{
        private static final String INSTRUCTION_PAGE_URL = "https://www.lego.com/en-us/service/buildinginstructions";

    @FindBy(xpath = "//option[@value='2022']")
    private WebElement yearFilter;

    @FindBy(xpath = "//input[@data-cy='search-bar-input']")
    private WebElement instructionSearchBarInput;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement instructionSearchBarSubmitButton;


    public InstructionPage openPage() {
        Browser.getDriver().get(INSTRUCTION_PAGE_URL);
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