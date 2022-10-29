package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

    public static WebDriver chooseBrowser(int browser)// 1-firefox, 2-chrome, 3-edge
    {
        WebDriver driver = null;
        switch (browser)
        {
            case 1:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case 2:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case 3:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                break;
        }
        return driver;
    }
}
