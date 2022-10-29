package pages;

import base.BaseClass;
import driverActions.Actions;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;

import static driverActions.Actions.*;

public class HomePage extends BaseClass {

    @FindBy(id = "nav-link-accountList")
    private WebElement loginButton;
    @FindBy(id = "createAccountSubmit")
    private WebElement registerButton;
    @FindBy(id = "nav-logo")
    private WebElement myStoreLogo;
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchProductBox;
    @FindBy(id="nav-search-submit-button")
    private WebElement searchButton;

    public HomePage(){
        PageFactory.initElements( getDriver(),this);
    }

    @Step("validate Logo")
    public boolean validateLogo(){
        return isDisplayed(myStoreLogo);
    }

    @Step("returns the title")
    public String getMyStoreTitle(){
        String myStoreTitle = getDriver().getTitle();
        Allure.addAttachment("Amazon.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return myStoreTitle;
    }

    @Step("Click on login and from there click on register")
    public RegisterPage enterRegister() {
        click(loginButton);//i had to go into sing in first
        waitUntilVisibilityElementLocated(registerButton);
        click(registerButton);
        Allure.addAttachment("register", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new RegisterPage();
    }

    @Step("click on  login")
    public LoginPage enterLogin() {
        click(loginButton);
        Allure.addAttachment("login button", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new LoginPage();
    }

    @Step("search product")
    public SearchResultPage searchProduct(String productName){
        waitUntilVisibilityElementLocated(searchProductBox);
        typeInto(productName,searchProductBox);
        click(searchButton);
        Allure.addAttachment("search results", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new SearchResultPage();
    }

    @Step("return the current url")
    public String getCurrURL(){
        String homePageURL =  getDriver().getCurrentUrl();
        return homePageURL;
    }
}
