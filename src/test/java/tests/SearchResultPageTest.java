package tests;


import base.BaseClass;
import dataprovider.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;


    @Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName){
        homePage = new HomePage();
        searchResultPage = homePage.searchProduct(productName);
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
    }

}
