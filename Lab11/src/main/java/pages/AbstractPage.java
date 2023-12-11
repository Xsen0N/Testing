package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import webDriver.Browser;

public class AbstractPage {
    private Logger log = LogManager.getRootLogger();

    public AbstractPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

}
