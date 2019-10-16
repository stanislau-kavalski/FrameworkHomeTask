package by.course.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingPage extends AbstractPage {

    private static final String CLOUD_JUMP_MENU_CLASSNAME = "cloud-jump-menu__toggle";
    private static final int MIN_WINDOW_WIDTH = 1280;

    @FindBy(linkText = "Calculators")
    private WebElement calculatorsBtn;

    public GoogleCloudCalculatorPage openCalculators() {
        if(getWindowWidth() < MIN_WINDOW_WIDTH) {
            refreshPage();
            waitUntilPresenceOfElementLocatedAndClick(By.className(CLOUD_JUMP_MENU_CLASSNAME));
        }
        clickElement(calculatorsBtn);
        return new GoogleCloudCalculatorPage();
    }
}
