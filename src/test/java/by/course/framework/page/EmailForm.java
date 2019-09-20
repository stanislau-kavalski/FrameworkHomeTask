package by.course.framework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailForm extends AbstractPage{

    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailBtn;

    public void switchToIframe() {
        if (getBrowserName().equals("chrome")) {
            driver.switchTo().frame(iFrame);
        }
    }

    public void enterEmail(String email) {
        emailField.sendKeys(Keys.ENTER, email);
    }

    public void sendEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailBtn)).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.name("emailForm")));
    }

    public EmailForm(WebDriver driver) {
        super(driver);
    }

    // Utils
    private String getBrowserName() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }
}
