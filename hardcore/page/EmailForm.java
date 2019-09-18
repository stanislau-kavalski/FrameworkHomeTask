package hardcore.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailForm {
    private WebDriver driver;

    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailBtn;

    public void switchToIframe() {
        driver.switchTo().frame(iFrame);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(Keys.ENTER, email);
    }

    public void sendEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailBtn)).click();
    }

    public EmailForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15),this);
    }
}
