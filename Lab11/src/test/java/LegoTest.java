import elements.MainPageElements;
import elements.ProductsElements;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InstructionPage;
import pages.MainPage;
import pages.ProductPage;
import webDriver.Browser;

public class LegoTest extends BaseTest {

    private static String inputData = "Harry Potter";

    @Test(description = "Test site navigation")
    public void testSiteNavigation() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .clickMainNavigationBarShopButton()
                .chooseFieldInShopOption()
                .getURL();
        Assert.assertTrue(Browser.getDriver().getCurrentUrl().contains("new-sets-and-products"), "The problem lies in navigation");
    }

    @Test(description = "Test site navigation using searchbar ")
    public void searchbarTest() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .clickSearchButton()
                .enterDataIntoSearchField(inputData)
                .submitInputData()
                .getURL();
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://www.lego.com/en-us/search?q=Harry+Potter", "The problem lies in navigation");
    }

    @Test(description = "Test to find lego instruction by date")
    public void findInstructionTest() {
        InstructionPage instructionPage = new InstructionPage();
        instructionPage.openPage()
                .chooseFilterValue();
        Assert.assertTrue(Browser.getDriver().getCurrentUrl().contains("2022"), "Problem with year filter");
    }

    @DataProvider(name = "testEmails")
    public Object[][] createIncorrectEmail() {
        return new Object[][]{
                {new String("user@.com")},
                {new String("йййй@ййй.ййй ")},
                {new String("   ")},
                {new String("user@..com ")},
                {new String("user@domain.")},
        };
    }

    @Test(dataProvider = "testEmails", description = "Test incorrect emails")
    public void testIncorrectEmails(String email) {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .enterDataInEmailInputField(email);
        MainPageElements mainPageElements = new MainPageElements();
        Assert.assertTrue(mainPageElements.isErrorMessageExist());

    }

    @Test(description = "Test adding product to the bag")
    public void addToBagTest() {
        ProductPage productPage = new ProductPage();
        productPage.openPage()
                .clickAddToBagButton();
        ProductsElements productsElements = new ProductsElements();
        Assert.assertTrue(productsElements.isAddProductMessageExist(), "Should be message that product was successfully added!");
    }

    @Test(description = "Find instruction by name")
    public void findInstructionByName() {
        InstructionPage instructionPage = new InstructionPage();
        instructionPage.openPage()
                .enterDataIntoSearchBar(inputData)
                .submitInputData();
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://www.lego.com/en-us/service/buildinginstructions/search?q=Harry%20Potter", "Problems with query processing");
    }

    @Test(description = "Test changing location page")
    public void testChangeLocation() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .clickLocationButton();
        MainPageElements locationMessage = new MainPageElements();
        Assert.assertTrue(locationMessage.isLocationHeaderDisplayed(), "There is problem with navigation");
    }

    @Test(description = "User should can open social sites links")
    public void testSocialSitesLinks() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .clickSocialSiteLink();
        Assert.assertTrue(Browser.getDriver().getCurrentUrl().contains("facebook"), "Url is not correct");
    }

    @Test(description = "Test unregister user add wish")
    public void testAddFavoriteUnregisterUser() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .clickWishButton();
        MainPageElements wishIcon = new MainPageElements();
        Assert.assertTrue(wishIcon.isWishListIconDisplayed(), "There are no register notification message");
    }


}
