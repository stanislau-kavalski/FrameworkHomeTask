package by.course.framework.page;

import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends AbstractPage {

    private static final String CLOUD_JUMP_MENU_CLASSNAME = "cloud-jump-menu__toggle";
    private static final int MIN_WINDOW_WIDTH = 1280;

    @FindBy(linkText = "Calculators")
    private WebElement calculatorsBtn;

    public GoogleCloudCalculatorPage openCalculators() {
        if(BrowserUtils.getWindowWidth(getDriver()) < MIN_WINDOW_WIDTH) {
            getDriver().navigate().refresh();
            waitUntilPresenceOfElementLocatedAndClick(By.className(CLOUD_JUMP_MENU_CLASSNAME));
        }
        calculatorsBtn.click();
        return new GoogleCloudCalculatorPage(getDriver());
    }

    public GoogleCloudPricingPage(WebDriver driver) {
        super(driver);
    }
}
