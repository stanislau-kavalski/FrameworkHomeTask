package by.course.framework.test;

import by.course.framework.page.*;
import by.course.framework.utils.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudTest extends CommonConditions {

    @BeforeMethod(alwaysRun = true)
    public void openCalculatorAndAddToEstimate() {
        GoogleCloudHomePage googleCloud = new GoogleCloudHomePage(driver);
        googleCloud.
                openHomePage().
                openProductsPage().
                openSeePricing().
                openCalculators().
                fillComputeEngineForm().
                pressEmailEstimate().
                openMailHomePage().
                getEmail().
                openEmailForm().
                enterEmail().
                sendEmail();
    }

    @Test
    public void checkCostInEstimatePageAndCostInEmail() {
        GoogleCloudCalculatorEstimatePage estimatePage = new GoogleCloudCalculatorEstimatePage(driver);
        String costInEstimatePage = estimatePage.getTotalPrice();
        BrowserUtils.switchToTab(driver, 1);
        MinuteMailHomePage emailPage = new MinuteMailHomePage(driver);
        emailPage.waitUntilEmailComesAndOpenIt();
        String costInEmail = emailPage.getTotalPrice();
        Assert.assertEquals(costInEmail, costInEstimatePage);
    }
}
