package tests;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {

    private LoginPage loginPage;
    private HomePage homePage;

    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
    @Description("Validate login")
    public void loginTest(String email, String pswd) throws Throwable {
        homePage = new HomePage();
        loginPage = homePage.enterLogin();
        loginPage.clickNextWithEmptyEmail();
        loginPage.clickNextWithOnlyLettersInEmailField();
        loginPage.delete();
        loginPage.clickNextWithCorrectEmail(email);
        loginPage.clickNextWithCorrectDetails(pswd);
        String actualURL = homePage.getCurrURL();
        String expectedURL ="https://www.amazon.com/ap/signin";
        Assert.assertEquals(actualURL , expectedURL);
    }
}
