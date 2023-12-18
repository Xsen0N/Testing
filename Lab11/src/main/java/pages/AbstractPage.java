package pages;

import org.openqa.selenium.support.PageFactory;
import webDriver.Browser;

public class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

}
