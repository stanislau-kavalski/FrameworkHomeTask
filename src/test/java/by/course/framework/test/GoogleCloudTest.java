package by.course.framework.test;

import by.course.framework.model.GpuData;
import by.course.framework.model.InstancesData;
import by.course.framework.model.MachineData;
import by.course.framework.model.OtherData;
import by.course.framework.page.*;
import by.course.framework.service.GpuDataCreator;
import by.course.framework.service.InstancesDataCreator;
import by.course.framework.service.MachineDataCreator;
import by.course.framework.service.OtherDataCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleCloudTest extends CommonConditions{
    private ArrayList<String> tabs;

    @BeforeMethod(alwaysRun = true)
    public void openCalculatorAndAddToEstimate() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openHomePage();
        googleCloudHomePage.openProductsPage();
        GoogleCloudProductsPage productsPage = new GoogleCloudProductsPage(driver);
        productsPage.openSeePricing();
        GoogleCloudPricingPage pricingPage = new GoogleCloudPricingPage(driver);
        pricingPage.openCalculators();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
        fillComputeEngineForm(calculatorPage);
        GoogleCloudCalculatorEstimatePage estimatePage = new GoogleCloudCalculatorEstimatePage(driver);
        estimatePage.pressEmailEstimate();
        openNewTab();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        MinuteMailHomePage emailPage = new MinuteMailHomePage(driver);
        emailPage.openHomePage();
        String email = emailPage.getEmail();
        driver.switchTo().window(tabs.get(0));
        EmailForm emailForm = new EmailForm(driver);
        emailForm.switchToIframe();
        emailForm.enterEmail(email);
        emailForm.sendEmail();
    }

    @Test
    public void checkCostInEstimatePageAndCostInEmail() {
        GoogleCloudCalculatorEstimatePage estimatePage = new GoogleCloudCalculatorEstimatePage(driver);
        String costInEstimatePage = estimatePage.getTotalPrice();
        driver.switchTo().window(tabs.get(1));
        MinuteMailHomePage emailPage = new MinuteMailHomePage(driver);
        emailPage.waitUntilEmailComesAndOpenIt();
        String costInEmail = emailPage.getTotalPrice();
        Assert.assertEquals(costInEmail, costInEstimatePage);
    }

    private void fillComputeEngineForm(GoogleCloudCalculatorPage calculatorPage) {
        InstancesData instancesData = InstancesDataCreator.withCredentialsFromProperty();
        MachineData machineData = MachineDataCreator.withCredentialsFromProperty();
        GpuData gpuData = GpuDataCreator.withCredentialsFromProperty();
        OtherData otherData = OtherDataCreator.withCredentialsFromProperty();
        calculatorPage.
                switchToIframe().
                selectComputeEngine().
                setNumberOfInstances(instancesData.getNumberOfInstances()).
                setWhatAreTheseInstanceFor(instancesData.getForWhatInstance()).
                setOperationSystemOrSoftware(otherData.getOperationSystemAndSoftware()).
                setMachineClass(machineData.getMachineClass()).
                setMachineType(machineData.getMachineType()).
                addGPUs().
                setNumberOfGPUs(gpuData.getNumberOfGPU()).
                setGpuType(gpuData.getGpuType()).
                setLocalSSD(otherData.getLocalSSD()).
                setDataCenterLocation(otherData.getDataCenterLocation()).
                setCommitedUsage(otherData.getCommitedUsage()).
                addToEstimate();
    }

    private void openNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }
}
