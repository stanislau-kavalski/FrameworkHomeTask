package by.course.framework.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtils {
    public static String getBrowserName(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    public static void openNewTab(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public static int getWindowWidth(WebDriver driver) {
        return driver.manage().window().getSize().getWidth();
    }
}
