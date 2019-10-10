package by.course.framework.test;

import by.course.framework.model.*;
import by.course.framework.page.*;
import by.course.framework.service.*;
import by.course.framework.utils.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudTest extends CommonConditions {

    @BeforeMethod(alwaysRun = true)
    public void openCalculatorAndAddToEstimate() {
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudHomePage(getDriver()).
                openHomePage().
                openProductsPage().
                openSeePricing().
                openCalculators().
                switchToCalculatorFormIframe();
        fillCalculatorData(calculatorPage);
        calculatorPage.
                clickAddToEstimate().
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

    private void fillCalculatorData(GoogleCloudCalculatorPage calculatorPage) {
        calculatorPage.clickComputeEngine();
        fillCalculatorInstancesData(calculatorPage);
        fillCalculatorMachineData(calculatorPage);
        fillCalculatorSoftwareAndSsdData(calculatorPage);
        fillCalculatorGpuData(calculatorPage);
        fillCalculatorLocationAndUsageData(calculatorPage);
    }

    private void fillCalculatorGpuData(GoogleCloudCalculatorPage calculatorPage) {
        CalculatorGpuData gpuData = CalculatorGpuDataCreator.create().
                withGpuNumber().
                withGpuType().
                build();
        calculatorPage.
                clickAddGpu().
                setNumberOfGPUs(gpuData.getNumberOfGPU()).
                setGpuType(gpuData.getGpuType());
    }

    private void fillCalculatorInstancesData(GoogleCloudCalculatorPage calculatorPage) {
        CalculatorInstancesData instancesData = CalculatorInstancesDataCreator.create().
                withInstancesNumber().
                withInstancesPurpose().
                build();
        calculatorPage.
                setNumberOfInstances(instancesData.getNumberOfInstances()).
                setWhatAreTheseInstanceFor(instancesData.getForWhatInstance());
    }

    private void fillCalculatorMachineData(GoogleCloudCalculatorPage calculatorPage) {
        CalculatorMachineData machineData = CalculatorMachineDataCreator.create().
                withMachineClass().
                withMachineType().
                build();
        calculatorPage.
                setMachineClass(machineData.getMachineClass()).
                setMachineType(machineData.getMachineType());
    }

    private void fillCalculatorSoftwareAndSsdData(GoogleCloudCalculatorPage calculatorPage) {
        CalculatorSoftwareAndSsdData softwareAndSsdData = CalculatorSoftwareAndSsdDataCreator.create().
                withSoftware().
                withSsd().
                build();
        calculatorPage.
                setOperationSystemOrSoftware(softwareAndSsdData.getOperationSystemAndSoftware()).
                setLocalSSD(softwareAndSsdData.getLocalSSD());
    }

    private void fillCalculatorLocationAndUsageData(GoogleCloudCalculatorPage calculatorPage) {
        CalculatorLocationAndUsageData locationAndUsageData = CalculatorLocationAndUsageDataCreator.create().
                withLocation().
                withCommitedUsage().
                build();
        calculatorPage.
                setDataCenterLocation(locationAndUsageData.getDataCenterLocation()).
                setCommitedUsage(locationAndUsageData.getCommitedUsage());
    }
}