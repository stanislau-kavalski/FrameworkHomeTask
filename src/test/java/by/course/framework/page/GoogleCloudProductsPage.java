package by.course.framework.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudProductsPage extends AbstractPage {

    @FindBy(linkText = "See pricing")
    private WebElement seePricingBtn;

    public GoogleCloudPricingPage openSeePricing() {
        defaultClickElement(seePricingBtn);
        return new GoogleCloudPricingPage();
    }
}
