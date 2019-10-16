package by.course.framework.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorEstimatePage extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";
    private static final String ONLY_DIGITS_REGEX = "[^0-9.,]+";

    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = "//*[@class='ng-binding'][contains(text(), 'Total Estimated Cost')]")
    private WebElement totalPrice;

    public MinuteMailHomePage pressEmailEstimate() {
        waitUntilElementToBeClickableAndClick(emailEstimate);
        waitUntilPresenceOfElementLocated(By.name(EMAIL_FORM_NAME));
        return new MinuteMailHomePage();
    }

    public String getTotalPrice() {
        String totalPrice = this.totalPrice.getText().replaceAll(ONLY_DIGITS_REGEX, StringUtils.EMPTY);
        return totalPrice.substring(0, totalPrice.length() - 1);
    }
}
