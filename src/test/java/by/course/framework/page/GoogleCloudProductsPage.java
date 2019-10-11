package by.course.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudProductsPage extends AbstractPage {

    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement seePricingBtn;

    public GoogleCloudProductsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingPage openSeePricing() {
        //Использовать новый метод с AbstractPage
        seePricingBtn.click();
        return new GoogleCloudPricingPage(getDriver());
    }
}
