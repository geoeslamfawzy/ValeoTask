package factories;

import driver.DriverManager;
import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    protected static void initBrowser(BrowserType browserType) {
        switch (browserType) {
            case FireFox:
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());
                break;
        }
    }
}
