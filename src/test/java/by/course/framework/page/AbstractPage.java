package by.course.framework.page;

import by.course.framework.model.ConfigTimeoutData;
import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ConfigTimeoutData.getCommonTimeout());
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, ConfigTimeoutData.getCommonTimeout()),this);
    }

    protected void clickOnWebElement(WebElement element) {
        BrowserUtils.scrollToElementAndClick(getDriver(), element);
    }

    protected void waitUntilPresenceOfElementLocatedAndClick(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement webElement = getDriver().findElement(element);
        clickOnWebElement(webElement);
    }

    protected void waitUntilPresenceOfElementLocated(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected void waitUntilElementToBeClickableAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickOnWebElement(element);
    }

    protected void waitUntilInvisibilityOfElementLocated(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected String waitUntilVisibilityOfElementLocatedAndGetText(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
