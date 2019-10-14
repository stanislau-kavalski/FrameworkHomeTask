package by.course.framework.page;

import by.course.framework.service.ConfigReader;
import by.course.framework.service.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(linkText = "See products")
    private WebElement seeProductsBtn;

    public GoogleCloudHomePage openHomePage() {
        //Создать новый метод на AbstractPage
        getDriver().get(ConfigReader.get(Constants.GOOGLE_CLOUD_HOMEPAGE_URL));
        return this;
    }

    public GoogleCloudProductsPage openProductsPage() {
        clickElement(seeProductsBtn);
        return new GoogleCloudProductsPage();
    }
}
