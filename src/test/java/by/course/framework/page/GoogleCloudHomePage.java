package by.course.framework.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(linkText = "See products")
    private WebElement seeProductsBtn;

    public GoogleCloudHomePage openHomePage() {
        openGoogleCloudHomePage();
        return this;
    }

    public GoogleCloudProductsPage openProductsPage() {
        clickElement(seeProductsBtn);
        return new GoogleCloudProductsPage();
    }
}
