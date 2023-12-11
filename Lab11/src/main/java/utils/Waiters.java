package utils;

import org.openqa.selenium.JavascriptExecutor;
import webDriver.Browser;

public class Waiters {

    public static Object getScriptToScrollPage() {
        return ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

}
