package by.course.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(linkText = "See products")
    private WebElement seeProductsBtn;

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
    }

    public void openProductsPage() {
        seeProductsBtn.click();
    }

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }
}
