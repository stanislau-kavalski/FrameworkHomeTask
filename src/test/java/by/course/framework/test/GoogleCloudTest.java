package by.course.framework.test;

import by.course.framework.model.OtherCalculatorData;
import by.course.framework.page.*;
import by.course.framework.service.OtherCalculatorDataCreator;
import by.course.framework.utils.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleCloudTest extends CommonConditions {

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = "GPU")
    public void openCalculatorAndAddToEstimate() {
        GoogleCloudHomePage googleCloud = new GoogleCloudHomePage(getDriver());
        googleCloud.
                openHomePage().
                openProductsPage().
                openSeePricing().
                openCalculators().
                switchToCalculatorFormIframe().
                fillOtherCalculatorData().
                pressEmailEstimate().
                openMailHomePage().
                getEmail().
                openEmailForm().
                enterEmail().
                sendEmail();
    }

    @Test
    public void checkCostInEstimatePageAndCostInEmail() {
        GoogleCloudCalculatorEstimatePage estimatePage = new GoogleCloudCalculatorEstimatePage(getDriver());
        String costInEstimatePage = estimatePage.getTotalPrice();
        BrowserUtils.switchToTab(getDriver(), 1);
        MinuteMailHomePage emailPage = new MinuteMailHomePage(getDriver());
        emailPage.OpenEmail();
        String costInEmail = emailPage.getTotalPrice();
        Assert.assertEquals(costInEmail, costInEstimatePage);
    }

    private GoogleCloudCalculatorEstimatePage fillOtherCalculatorData() {
        OtherCalculatorData otherCalculatorData = OtherCalculatorDataCreator.create().
                withSoftware().
                withSsd().
                withLocation().
                withCommitedUsage().
                build();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(getDriver());
        calculatorPage.
                setOperationSystemOrSoftware(otherCalculatorData.getOperationSystemAndSoftware()).
                setLocalSSD(otherCalculatorData.getLocalSSD()).
                setDataCenterLocation(otherCalculatorData.getDataCenterLocation()).
                setCommitedUsage(otherCalculatorData.getCommitedUsage());
        return new GoogleCloudCalculatorEstimatePage(getDriver());
    }
}
