package by.course.framework.page;

import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingPage extends AbstractPage {
    @FindBy(linkText = "Calculators")
    private WebElement calculatorsBtn;

    public void openCalculators() {
        if(BrowserUtils.getWindowWidth(driver) < 1280) {
            driver.navigate().refresh();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("cloud-jump-menu__toggle"))).click();
        }
        calculatorsBtn.click();
    }

    public GoogleCloudPricingPage(WebDriver driver) {
        super(driver);
    }
}
