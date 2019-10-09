package by.course.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudProductsPage extends AbstractPage {

    @FindBy(linkText = "See pricing")
    private WebElement seePricingBtn;

    public GoogleCloudPricingPage openSeePricing() {
        seePricingBtn.click();
        return new GoogleCloudPricingPage(getDriver());
    }

    public GoogleCloudProductsPage(WebDriver driver) {
        super(driver);
    }
}
