package by.course.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends AbstractPage {
    @FindBy(linkText = "Calculators")
    private WebElement calculatorsBtn;

    public void openCalculators() {
        calculatorsBtn.click();
    }

    public GoogleCloudPricingPage(WebDriver driver) {
        super(driver);
    }
}
