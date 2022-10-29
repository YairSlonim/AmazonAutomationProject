package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.time.Duration;

public class BaseClass {
    private static WebDriverWait wait ;
    private static WebDriver wd ;

    @BeforeTest
    public void createDriver()
    {
        wd = Utils.chooseBrowser(2);
        wait = new WebDriverWait(wd, Duration.ofSeconds(3));
        wd.manage().window().maximize();
        wd.get("https://www.amazon.com");
    }

    public static WebDriver getDriver() {
        return wd;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

//    @AfterTest
//    public void Teardown() {
//        wd.quit();
//    }
}
