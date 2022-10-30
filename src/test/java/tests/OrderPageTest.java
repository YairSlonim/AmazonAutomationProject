package tests;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.CartPage;
import pages.SearchResultPage;

public class OrderPageTest extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private CartPage cartPage;

    @Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    @Description("Adds products to the cart and then verifies that the final price is correct.")
    public void verifyTotalPrice(String productName, String size, String qty){
        homePage = new HomePage();
        searchResultPage = homePage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        cartPage = addToCartPage.clickOnAddToCart();
        Double unitPrice = cartPage.getUnitPrice();
        Double totalPrice = cartPage.getTotalPrice();
        Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)));
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }
}
