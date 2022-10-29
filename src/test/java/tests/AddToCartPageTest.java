package tests;


import base.BaseClass;
import dataprovider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private CartPage cartPage;

    @Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void addToCartTest(String productName, String size, String qty){
        homePage = new HomePage();
        searchResultPage = homePage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        cartPage = addToCartPage.clickOnAddToCart();
        boolean result = cartPage.validateAddToCart();
        Assert.assertTrue(result);
    }

}
