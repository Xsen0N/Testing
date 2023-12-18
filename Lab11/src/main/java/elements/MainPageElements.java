package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Browser;

import java.util.List;

public class MainPageElements extends AbstractElement{
    private String errorMessage = "//span[@class='EmailSubscriptionstyles__InputError-sc-48ulj8-4 fTURKp']";
    private String locationMessage = "//h2[@class='Text__BaseText-sc-13i1y3k-0 zkrlj sharedstyles__StyledText-ubbvf-1 cKJJpA']";
    private String wishListIcon = "//div[@class='Modalstyles__ModalWindow-l3z049-1 inSJbY']";

    public boolean isErrorMessageExist() {
        return !getElements(errorMessage).isEmpty();
    }

    public boolean isLocationHeaderDisplayed() {
        return getElements(locationMessage).get(0).isDisplayed();
    }

    public boolean isWishListIconDisplayed() {
        return getElements(wishListIcon).get(0).isDisplayed();
    }


}
