package pages;

import base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    @FindBy(xpath="//h1[normalize-space()='Select a shipping address']")
    private WebElement addressPageMessage;

    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("return address page message")
    public String validateAddressMessage() {
        String confirmMsg = addressPageMessage.getText();
        return confirmMsg;
    }
}
