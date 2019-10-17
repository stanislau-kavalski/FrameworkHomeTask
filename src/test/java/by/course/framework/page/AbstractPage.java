package by.course.framework.page;

import by.course.framework.driver.DriverSingleton;
import by.course.framework.service.ConfigReader;
import by.course.framework.service.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class AbstractPage {

    private WebDriver driver  = DriverSingleton.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT)));
    private static ArrayList<String> tabs;
    /**
     * Смысл фреймворка в том, чтобы он был абстрактным, и классы фреймворка не знали о конкретной реализации.
     * AbstractPage - это класс фреймворка, тогда как GoogleCloudCalculatorPage - это класс тестов.
     * Ты можешь в идеале написать один фреймворк, который смогут использовать разные тесты.
     * Т.е. основная мысль - фреймворк не должен знать о каких-то конкретных локаторах или сраницах,
     * он должен только предоставлять методы, которые с этим работают.
     * Если еще короче, тут этой константы не надо)
     */
    private static final String GOOGLE_EMAIL_MESSAGE_XPATH = "//span[contains(text(), 'noreply@google.com')]/parent::h3";

    protected AbstractPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Integer.parseInt(ConfigReader.get(Constants.COMMON_TIMEOUT))),this);
    }

    /**
     * Относится к прошлому комментарию. Фреймворк предоставляет метод openPage, а конкретные страницы уже могут определять
     * какую конкретную страницу открывать. Т.е. эти методы openGoogleCloudHomePage, openMinuteMailHomePage должны быть на своих страницах
     */
    protected void openGoogleCloudHomePage() {
        driver.get(ConfigReader.get(Constants.GOOGLE_CLOUD_HOMEPAGE_URL));
    }

    protected void openMinuteMailHomePage() {
        driver.get(ConfigReader.get(Constants.MINUTE_MAIL_HOMEPAGE_URL));
    }

    /**
     * Тут бы я изменил название на clickWithJs
     * @param element
     */
    protected void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // а это просто сlickElement
    protected void defaultClickElement(WebElement element) {
        element.click();
    }

    protected void waitUntilPresenceOfElementLocatedAndClick(By element) {
        //Не забывай переиспользовать методы. Тут можно было waitUntilPresenceOfElementLocated(element); Исправь тут и делее
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement webElement = driver.findElement(element);
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

    // Этот метод не должен быть на абстракт
    protected void waitUntilEmailComesAndOpenIt() {
        new WebDriverWait(driver, Integer.parseInt(ConfigReader.get(Constants.EMAIL_TIMEOUT)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GOOGLE_EMAIL_MESSAGE_XPATH))).sendKeys(Keys.ENTER);
    }

    protected void openNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    protected void switchToTab(int tabNumber) {
        driver.switchTo().window(tabs.get(tabNumber));
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected int getWindowWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    protected void switchToFrameOnlyInChrome(WebElement element) {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        if (capabilities.getBrowserName().equalsIgnoreCase("chrome")) {
            driver.switchTo().frame(element);
        }
    }

    protected void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    protected void setValue(WebElement element, String text) {
        element.sendKeys(text);
    }
}
