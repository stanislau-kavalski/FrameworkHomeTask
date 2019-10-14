package by.course.framework.page;

import by.course.framework.driver.DriverSingleton;
import by.course.framework.service.ConfigReader;
import by.course.framework.service.Constants;
import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    /**
     * Давай сделаем красивее.
     * 1. Не надо делать драйвер протектед. Никому он там в наследниках не нужен
     * 2. Определи на этой странице методы обертки для вебдрайвер действий:
     * clickElement(WebElement element) - уже есть молодец
     * остальные методы я описал на других Page* классах
     *
     *
     */
    private WebDriver driver  = DriverSingleton.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT)));

    protected AbstractPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT))),this);
    }
    
    protected void clickElement(WebElement element) {
        BrowserUtils.scrollToElementAndClick(getDriver(), element);
    }

    protected void waitUntilPresenceOfElementLocatedAndClick(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement webElement = getDriver().findElement(element);
        clickElement(webElement);
    }

    protected void waitUntilPresenceOfElementLocated(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected void waitUntilElementToBeClickableAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElement(element);
    }

    protected void waitUntilInvisibilityOfElementLocated(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected String waitUntilVisibilityOfElementLocatedAndGetText(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    // Этот метод можно будет убрать. Страницы потомки не будут напрямую работать с драйвером. А только с методами этой страницы.
    protected WebDriver getDriver() {
        return driver;
    }
}
