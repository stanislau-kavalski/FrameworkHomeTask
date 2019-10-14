package by.course.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorEstimatePage extends AbstractPage {

    private static final String EMAIL_FORM_NAME = "emailForm";

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
        // Не делай "", делай StringUtils.EMPTY
        // [^0-9.,]+  в константы
        String totalPrice = this.totalPrice.getText().replaceAll("[^0-9.,]+","");
        totalPrice = totalPrice.substring(0, totalPrice.length() - 1);
        /*Ненужный ассайнмент.
        Делать так не нужно. Можно просто
            return totalPrice.substring(0, totalPrice.length() - 1);*/
        return totalPrice;
    }

}
