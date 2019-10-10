package by.course.framework.page;

import by.course.framework.model.ConfigHomePageData;
import by.course.framework.model.ConfigTimeoutData;
import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinuteMailHomePage extends AbstractPage {

    private static final String GOOGLE_EMAIL_MESSAGE_XPATH = "//span[contains(text(), 'noreply@google.com')]/parent::h3";
    private static final String EMAIL_TOTAL_PRICE_XPATH = "//*[@class='quote']//h3[contains(text(), 'USD')]";

    @FindBy(id = "mailAddress")
    private WebElement email;

    public MinuteMailHomePage openMailHomePage() {
        BrowserUtils.openNewTab(getDriver());
        BrowserUtils.switchToTab(getDriver(), 1);
        getDriver().get(ConfigHomePageData.getMinuteMailHomePageUrl());
        return this;
    }

    public EmailForm getEmail() {
        return new EmailForm(getDriver(), email.getAttribute("value"));
    }

    public void OpenEmail() {
        waitUntilEmailComesAndOpenIt();
    }

    public String getTotalPrice() {
        return leaveOnlyDigitsInText(waitUntilVisibilityOfElementLocatedAndGetText(By.xpath(EMAIL_TOTAL_PRICE_XPATH)));
    }

    private String leaveOnlyDigitsInText(String text) {
        return text.replaceAll("[^0-9.,]+","");
    }

    private void waitUntilEmailComesAndOpenIt() {
        new WebDriverWait(getDriver(), ConfigTimeoutData.getEmailTimeout())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GOOGLE_EMAIL_MESSAGE_XPATH))).sendKeys(Keys.ENTER);
    }

    public MinuteMailHomePage(WebDriver driver) {
        super(driver);
    }
}
