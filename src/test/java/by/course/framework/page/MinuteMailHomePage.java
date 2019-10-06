package by.course.framework.page;

import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinuteMailHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://10minutemail.com/";
    private static final String GOOGLE_EMAIL_MESSAGE_XPATH = "//span[contains(text(), 'noreply@google.com')]/parent::h3";
    private static final String EMAIL_TOTAL_PRICE_XPATH = "//*[@class='quote']//h3[contains(text(), 'USD')]";
    private static final int WAIT_EMAIL_TIMEOUT_SECONDS = 180;

    @FindBy(id = "mailAddress")
    private WebElement email;

    public MinuteMailHomePage openMailHomePage() {
        BrowserUtils.openNewTab(driver);
        BrowserUtils.switchToTab(driver, 1);
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public EmailForm getEmail() {
        return new EmailForm(driver, email.getAttribute("value"));
    }

    public void waitUntilEmailComesAndOpenIt() {
        new WebDriverWait(driver, WAIT_EMAIL_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GOOGLE_EMAIL_MESSAGE_XPATH))).sendKeys(Keys.ENTER);
    }

    public String getTotalPrice() {
        return leaveOnlyDigitsInText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_TOTAL_PRICE_XPATH))).getText());
    }

    private String leaveOnlyDigitsInText(String text) {
        return text.replaceAll("[^0-9.,]+","");
    }

    public MinuteMailHomePage(WebDriver driver) {
        super(driver);
    }
}
