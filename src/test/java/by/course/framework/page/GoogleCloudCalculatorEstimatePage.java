package by.course.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorEstimatePage extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";

    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = "//*[@class='ng-binding'][contains(text(), 'Total Estimated Cost')]")
    private WebElement totalPrice;

    public MinuteMailHomePage pressEmailEstimate() {
        waitUntilElementToBeClickableAndSendKeys(emailEstimate);
        waitUntilPresenceOfElementLocated(By.name(EMAIL_FORM_NAME));
        return new MinuteMailHomePage(getDriver());
    }

    public String getTotalPrice() {
        String totalPrice = this.totalPrice.getText().replaceAll("[^0-9.,]+","");
        totalPrice = totalPrice.substring(0, totalPrice.length() - 1);
        return totalPrice;
    }

    public GoogleCloudCalculatorEstimatePage(WebDriver driver) {
        super(driver);
    }
}
