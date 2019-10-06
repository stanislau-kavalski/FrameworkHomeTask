package by.course.framework.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebElement waitUntilPresenceOfElementLocatedByXpath(String elementXpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT_SECONDS),this);
    }
}
