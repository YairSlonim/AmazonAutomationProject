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

public class RegisterPage extends BaseClass {

    @FindBy(id = "ap_customer_name")
    private WebElement firstAndLastName;
    @FindBy(id = "ap_email")
    private WebElement emailInput;
    @FindBy(id = "ap_password")
    private WebElement passwordInput;
    @FindBy(id = "ap_password_check")
    private WebElement passwordConfirmInput;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(css = "div[id='auth-password-mismatch-alert'] div[class='a-alert-content']")
    private WebElement passwordErrorMsg;

    public RegisterPage(){
        PageFactory.initElements( getDriver(),this);
    }

    @Step("Click continue with wrong confirm password field, all the rest fields are correct" +
            " and print the error message")
    public void clickContinueWithWrongConfirmPassword(String fullName, String email, String password, String confirm)
    {
        typeInto(fullName,firstAndLastName);
        typeInto(email, emailInput);
        typeInto(password,passwordInput);
        typeInto(confirm,passwordConfirmInput);
        click(continueButton);
        waitUntilVisibilityElementLocated(passwordErrorMsg);
        System.out.println("empty password msg : "+ passwordErrorMsg.getText());
        Allure.addAttachment("error message after click continue with wrong confirm password", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Delete all fields values")
    public void deleteFromFields()
    {
        removeInput(firstAndLastName,firstAndLastName.getAttribute("value"));
        removeInput(emailInput,emailInput.getAttribute("value"));
        removeInput(passwordInput,passwordInput.getAttribute("value"));
        removeInput(passwordConfirmInput,passwordConfirmInput.getAttribute("value"));
        Allure.addAttachment("empty form", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click continue with correct values")
    public void clickContinueWithCorrectFields(String fullName, String email, String password, String ConfirmPassword)
    {
        typeInto(fullName,firstAndLastName);
        typeInto(email, emailInput);
        typeInto(password,passwordInput);
        typeInto(ConfirmPassword,passwordConfirmInput);
        click(continueButton);
        Allure.addAttachment("continue with correct fields", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
