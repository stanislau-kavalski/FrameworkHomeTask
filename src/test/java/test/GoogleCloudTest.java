package hardcore.test;

import hardcore.page.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleCloudTest {
    private WebDriver driver;
    private ArrayList<String> tabs;

    @BeforeClass(alwaysRun = true)
    public void openCalculatorAndAddToEstimate() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        tabs = new ArrayList<String>(driver.getWindowHandles());
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

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    public void fillComputeEngineForm(GoogleCloudCalculatorPage calculatorPage) {
        int numberOfInstances = 4;
        String forWhatInstance = "";
        String operationSystemAndSoftware = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String machineClass = "Regular";
        String machineType = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        int numberOfGPUs = 1;
        String gpuType = "NVIDIA Tesla V100";
        String localSSD = "2x375 GB";
        String dataCenterLocation = "Frankfurt (europe-west3)";
        String commitedUsage = "1 Year";
        calculatorPage.
                switchToIframe().
                selectComputeEngine().
                setNumberOfInstances(numberOfInstances).
                setWhatAreTheseInstanceFor(forWhatInstance).
                setOperationSystemOrSoftware(operationSystemAndSoftware).
                setMachineClass(machineClass).
                setMachineType(machineType).
                addGPUs().
                setNumberOfGPUs(numberOfGPUs).
                setGpuType(gpuType).
                setLocalSSD(localSSD).
                setDataCenterLocation(dataCenterLocation).
                setCommitedUsage(commitedUsage).
                addToEstimate();
    }

    public void openNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }
}
