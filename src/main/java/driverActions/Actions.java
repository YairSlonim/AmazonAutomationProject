package driverActions;

import base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Actions extends BaseClass {

    public static void waitUntilVisibilityElementLocated(WebElement elem) {
        getWait().until(ExpectedConditions.visibilityOf(elem));
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static WebElement typeInto(String Text, WebElement elem){
        elem.sendKeys(Text);
        return elem;
    }

    public static void click(WebElement elem) {
        elem.click();
    }

    public static boolean isDisplayed(WebElement ele) {
        boolean flag = ele.isDisplayed();
        if(flag){
            System.out.println("The element is Displayed");
        }else{
            System.out.println("The element is not Displayed");
        }
        return flag;
    }

    public static void removeInput(WebElement elem, String str) {
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            elem.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static void impWait() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void fluentWait(WebElement element) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e) {
        }
    }

    public static boolean selectByVisibleText(String visibleText, WebElement ele) {
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibleText);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean JSClick(WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", ele);
            flag = true;
        }
        catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed");
            } else if (!flag) {
                System.out.println("Click Action is not performed");
            }
        }
        return flag;
    }

    public static void selectFromDropDownListByVisibileText(WebElement elem, String text) {
        Select select = new Select(elem);
        select.selectByVisibleText(text);
    }
}
