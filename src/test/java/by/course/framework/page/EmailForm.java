package by.course.framework.page;

import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EmailForm extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";
    private String email;

    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailBtn;

    private void switchToIframe() {
        if (BrowserUtils.getBrowserName(getDriver()).equals("chrome")) {
            getDriver().switchTo().frame(iFrame);
        }
    }

    public EmailForm openEmailForm() {
        BrowserUtils.switchToTab(getDriver(), 0);
        switchToIframe();
        return this;
    }

    public EmailForm enterEmail() {
        emailField.sendKeys(Keys.ENTER, email);
        return this;
    }

    public void sendEmail() {
        waitUntilElementToBeClickableAndClick(sendEmailBtn);
        waitUntilInvisibilityOfElementLocated(By.name(EMAIL_FORM_NAME));
    }

    public EmailForm(WebDriver driver, String email) {
        super(driver);
        this.email = email;
    }
}
