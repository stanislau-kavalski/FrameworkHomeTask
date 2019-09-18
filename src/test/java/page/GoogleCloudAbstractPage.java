package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class GoogleCloudAbstractPage {
    protected WebDriver driver;

    protected GoogleCloudAbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15),this);
    }
}
