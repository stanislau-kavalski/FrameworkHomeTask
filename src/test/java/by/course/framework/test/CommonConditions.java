package by.course.framework.test;

import by.course.framework.driver.DriverSingleton;
import by.course.framework.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;

@Listeners({TestListener.class})
public class CommonConditions {

    private WebDriver driver;

    @BeforeClass()
    public void setUp()
    {
        driver = DriverSingleton.setDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    protected void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
