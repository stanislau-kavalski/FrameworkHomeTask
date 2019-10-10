package by.course.framework.page;

import by.course.framework.model.ConfigHomePageData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(linkText = "See products")
    private WebElement seeProductsBtn;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openHomePage() {
        getDriver().get(ConfigHomePageData.getGoogleCloudHomePageUrl());
        return this;
    }

    public GoogleCloudProductsPage openProductsPage() {
        clickOnWebElement(seeProductsBtn);
        return new GoogleCloudProductsPage(getDriver());
    }
}
