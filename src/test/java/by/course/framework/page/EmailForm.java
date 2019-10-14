package by.course.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.course.framework.utils.BrowserUtils;

public class EmailForm extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";
    private String email;

    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailBtn;

    public EmailForm(String email) {
        // не надо сетать имейл сюда. Его надо передавать в enterEmail()
        this.email = email;
    }

    public EmailForm openEmailForm() {
        // определить на AbstractPage метод switchToTab(int) и использовать.
        // Кстати, BrowserUtils тогда тебе не нужен вовсе
        BrowserUtils.switchToTab(getDriver(), 0);
        switchToIframe();
        return this;
    }

    public EmailForm enterEmail() {
        //определить на AbstractPage метод setValue(WebElement, String) и использовать
        emailField.sendKeys(Keys.ENTER, email);
        return this;
    }

    public void sendEmail() {
        waitUntilElementToBeClickableAndClick(sendEmailBtn);
        waitUntilInvisibilityOfElementLocated(By.name(EMAIL_FORM_NAME));
    }

    private void switchToIframe() {
        // определить на AbstractPage метод switchTo(WebElement) и использовать
        // И логику по обработке имени браузера засунуть туда же засунуть туда же
        // вместо String.equals(String) используй плиз StringUtils.equalsIgnoreCase()
        if (BrowserUtils.getBrowserName(getDriver()).equals("chrome")) {
            getDriver().switchTo().frame(iFrame);
        }
    }
}
