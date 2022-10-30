package tests;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EndToEndTest extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private AddressPage addressPage;

    @Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    @Description("login to amazon then search a product, put the product in the cart and then continue until address page.")
    public void endToEndTest(String productName, String size, String qty) throws Throwable {
        homePage = new HomePage();
        loginPage = homePage.enterLogin();
        loginPage.clickNextWithCorrectEmail("yairslo7@gmail.com");
        loginPage.clickNextWithCorrectDetails("9067149906");
        searchResultPage = homePage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        cartPage =addToCartPage.clickOnAddToCart();
        addressPage = cartPage.clickOnCheckOut();
        String actualMessage = addressPage.validateAddressMessage();
        String expectedMsg = "Select a shipping address";
        Assert.assertEquals(actualMessage, expectedMsg);
    }
}
