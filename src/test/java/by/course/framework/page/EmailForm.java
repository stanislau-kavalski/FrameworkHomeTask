package by.course.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailForm extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";

    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailBtn;

    // Еще раз, не надо в кострукторе передать email
    public EmailForm(String email) {
        openEmailForm();
        enterEmail(email);
    }

    // тут можно передать email
    public void sendEmail() {
        waitUntilElementToBeClickableAndClick(sendEmailBtn);
        waitUntilInvisibilityOfElementLocated(By.name(EMAIL_FORM_NAME));
    }

    private void openEmailForm() {
        switchToTab(0);
        switchToFrameOnlyInChrome(iFrame);
    }

    private void enterEmail(String email) {
        setValue(emailField, email);
    }
}
