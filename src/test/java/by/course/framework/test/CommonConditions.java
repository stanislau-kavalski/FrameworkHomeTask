package by.course.framework.test;

import by.course.framework.driver.DriverSingleton;
import by.course.framework.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
