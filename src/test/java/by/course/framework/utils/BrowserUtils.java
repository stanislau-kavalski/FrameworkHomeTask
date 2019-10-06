package by.course.framework.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;

public class BrowserUtils {

    private static ArrayList<String> tabs;

    public static String getBrowserName(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    public static void openNewTab(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToTab(WebDriver driver, int tabNumber) {
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public static int getWindowWidth(WebDriver driver) {
        return driver.manage().window().getSize().getWidth();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
