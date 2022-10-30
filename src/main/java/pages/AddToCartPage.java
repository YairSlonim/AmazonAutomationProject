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

public class AddToCartPage extends BaseClass {

    @FindBy(id = "quantity")
    private WebElement quantity;
    @FindBy(id = "native_dropdown_selected_size_name")
    private WebElement size;
    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartBtn;

    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @Step("enter product quantity")
    public void enterQuantity(String quantity1){
        waitUntilVisibilityElementLocated(quantity);
        selectFromDropDownListByVisibileText(quantity,quantity1);
        Allure.addAttachment("fill quantity field", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("enter product size")
    public void selectSize(String size1){
        selectFromDropDownListByVisibileText(size,size1);
        Allure.addAttachment("fill size field", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click on add to cart button")
    public CartPage clickOnAddToCart(){
        click(addToCartBtn);
        Allure.addAttachment("added to cart message", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new CartPage();
    }
}
