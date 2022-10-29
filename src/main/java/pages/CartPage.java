package pages;

import base.BaseClass;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;

import static driverActions.Actions.*;
public class CartPage extends BaseClass {

    @FindBy(id = "NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    private WebElement addToCartMessage;
    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToCheckOutBtn;
    @FindBy(css = "span.ewc-unit-price.ewc-wider-compact-view-only > span")
    private WebElement unitPrice;

    @FindBy(xpath = "//span[@class='a-size-base a-color-price a-text-bold']")
    private WebElement totalPrice;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToCheckOut;

    public CartPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @Step("validate that the product is in the cart")
    public boolean validateAddToCart(){
        fluentWait(addToCartMessage);
        return isDisplayed(addToCartMessage);
    }

    @Step("click on check out button and moving to order page")
    public AddressPage clickOnCheckOut(){
        fluentWait(proceedToCheckOutBtn);
        JSClick(proceedToCheckOutBtn);
        Allure.addAttachment("order page", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new AddressPage();
    }

    @Step("return unit price")
    public double getUnitPrice(){
        String unitPrice1 = unitPrice.getText();
        String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice/100;
    }

    @Step("return all cart total price")
    public double getTotalPrice(){
        String totalPrice1 = totalPrice.getText();
        String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(tot);
        return finalTotalPrice/100;
    }
}
