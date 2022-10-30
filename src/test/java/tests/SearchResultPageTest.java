package tests;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    @Description("Search product  and validate that the product is exists.")
    public void productAvailabilityTest(String productName){
        homePage = new HomePage();
        searchResultPage = homePage.searchProduct(productName);
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
    }
}
