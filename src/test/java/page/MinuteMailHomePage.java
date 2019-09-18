package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinuteMailHomePage {
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";
    private WebDriver driver;

    @FindBy(id = "mailAddress")
    private WebElement email;

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public void waitUntilEmailComesAndOpenIt() {
        new WebDriverWait(driver, 120)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'noreply@google.com')]/parent::h3"))).sendKeys(Keys.ENTER);
    }

    public String getTotalPrice() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='quote']//h3[contains(text(), 'USD')]"))).getText().replaceAll("[^0-9.,]+","");
    }

    public MinuteMailHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15),this);
    }
}
