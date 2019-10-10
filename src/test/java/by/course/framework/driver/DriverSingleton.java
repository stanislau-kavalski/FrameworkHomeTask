package by.course.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    driver = createFirefoxDriver();
                    break;
                }
                case "chrome": {
                    driver = createChromeDriver();
                    break;
                }
                default: {
                    driver = createChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    private DriverSingleton() {
        throw new AssertionError("Cannot be instantiated directly.");
    }
}
