package tests;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.HashMap;

public class RegisterTest extends BaseClass {

    private RegisterPage registerPage;
    private HomePage homePage;

    @Test(dataProvider = "newAccountDetailsData", dataProviderClass = DataProviders.class)
    @Description("Validate register")
    public void registerTest(HashMap<String,String> hashMapValue) throws Throwable {
        homePage = new HomePage();
        registerPage = homePage.enterRegister();
        registerPage.clickContinueWithWrongConfirmPassword(
                hashMapValue.get("FirstAndLastName"),
                hashMapValue.get("Email"),
                hashMapValue.get("Password"),
                "1111111111"
        );
        registerPage.deleteFromFields();
        registerPage.clickContinueWithCorrectFields(
                hashMapValue.get("FirstAndLastName"),
                hashMapValue.get("Email"),
                hashMapValue.get("Password"),
                hashMapValue.get("ConfirmPassword"));
    }

}
