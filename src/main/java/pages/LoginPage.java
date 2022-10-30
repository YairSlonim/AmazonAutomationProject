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

public class LoginPage extends BaseClass {

    @FindBy(id = "continue")
    private WebElement nextEmailButton;
    @FindBy(id = "signInSubmit")
    private WebElement nextPasswordButton;
    @FindBy(xpath = "(//div[@class='a-box-inner a-alert-container'])[2]")
    private WebElement EmptyEmailErrorMsg;
    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement emailErrorMsg;
    @FindBy(id = "ap_email")
    private WebElement emailInput;
    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    public LoginPage(){
        PageFactory.initElements( getDriver(),this);
    }

    @Step("Click next with empty email field and print the error message")
    public void clickNextWithEmptyEmail()
    {
        click(nextEmailButton);
        waitUntilVisibilityElementLocated(EmptyEmailErrorMsg);
        System.out.println(EmptyEmailErrorMsg.getText());
        Allure.addAttachment("error message after click continue with empty email", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click next with only letters in email field and print the error message")
    public void clickNextWithOnlyLettersInEmailField()
    {
        typeInto("aaaaasssdfg", emailInput);
        click(nextEmailButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println(emailErrorMsg.getText());
        Allure.addAttachment("error message after click continue with wrong email", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Delete email field value")
    public void deleteFromField()
    {
        emailInput.clear();
        Allure.addAttachment("empty form", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click next correct email")
    public void clickNextWithCorrectEmail(String username)
    {
        typeInto(username, emailInput);
        click(nextEmailButton);
        Allure.addAttachment("password page in login process", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click next with correct password")
    public HomePage clickNextWithCorrectDetails(String pw)
    {
        waitUntilVisibilityElementLocated(passwordInput);
        typeInto(pw, passwordInput);
        click(nextPasswordButton);
        impWait();
        Allure.addAttachment("click next with correct password", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        return new HomePage();
    }
}
