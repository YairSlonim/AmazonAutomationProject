package tests;

import base.BaseClass;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseClass {

    private HomePage homePage;

    @Test
    @Description("Verify the amazon home page logo.")
    public void verifyLogo(){
        homePage = new HomePage();
        boolean result = homePage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    @Description("Verify the amazon home page title.")
    public void verifyTitle() {
        homePage = new HomePage();
        String actTitle=homePage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "Amazon.com. Spend less. Smile more.");
    }
}
