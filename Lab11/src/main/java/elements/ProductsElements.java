package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Browser;

import java.util.List;

public class ProductsElements extends AbstractElement {
    private String addProductMessage = "//div[@data-test='add-to-bag-modal']";

    public boolean isAddProductMessageExist() {
        return getElements(addProductMessage).isEmpty();
    }

}
