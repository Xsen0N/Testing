package webDriver;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;


public class Browser {
    private static int DEFAULT_WAIT_IN_SECONDS = 30;
    private static WebDriver driver;

    public static void initDriver() {
        driver = BrowserFactory.createDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }


}
