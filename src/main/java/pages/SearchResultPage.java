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

public class SearchResultPage extends BaseClass {

    @FindBy(xpath = "(//a[@class='a-link-normal s-no-outline'])[2]")
    private WebElement productResult;

    public SearchResultPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @Step("check if product available")
    public boolean isProductAvailable(){
        return isDisplayed(productResult);
    }

    @Step("click on product result and moving to addToCart page")
    public AddToCartPage clickOnProduct(){
        click(productResult);
        Allure.addAttachment("addToCart page", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new AddToCartPage();
    }
}
