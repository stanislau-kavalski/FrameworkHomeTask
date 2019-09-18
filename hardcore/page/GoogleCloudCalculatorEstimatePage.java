package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudCalculatorEstimatePage extends GoogleCloudAbstractPage {
    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(xpath = "//*[@class='ng-binding'][contains(text(), 'Total Estimated Cost')]")
    private WebElement totalPrice;

    public void pressEmailEstimate() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(emailEstimate)).click();
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
