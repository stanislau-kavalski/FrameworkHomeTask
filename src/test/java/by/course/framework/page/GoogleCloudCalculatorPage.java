package by.course.framework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudCalculatorPage extends AbstractPage {
    @FindBy(id = "idIframe")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@class='name ng-binding' and text()='Compute Engine']")
    private WebElement computeEngineSectionBtn;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.label']")
    private WebElement whatAreTheseInstanceFor;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemOrSoftwareList;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClassList;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeList;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUs;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSsdList;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageList;

    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    public GoogleCloudCalculatorPage switchToIframe() {
        driver.switchTo().frame(iFrame);
        return this;
}

    public GoogleCloudCalculatorPage selectComputeEngine() {
        computeEngineSectionBtn.click();
        return this;
    }

    public GoogleCloudCalculatorPage setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public GoogleCloudCalculatorPage setWhatAreTheseInstanceFor(String instancesFor) {
        whatAreTheseInstanceFor.sendKeys(instancesFor);
        return this;
    }

    public GoogleCloudCalculatorPage setOperationSystemOrSoftware(String operationSystem) {
        operationSystemOrSoftwareList.click();
        WebElement operationSystemUserChoice = chooseElementFromDropDownList(operationSystem);
        operationSystemUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setMachineClass(String machineClass) {
        machineClassList.sendKeys(Keys.ENTER);
        WebElement machineClassUserChoice = chooseElementFromDropDownList(machineClass);
        machineClassUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setMachineType(String machineType) {
        scrollToElement(machineTypeList);
        machineTypeList.sendKeys(Keys.ENTER);
        WebElement machineTypeUserChoice = chooseElementFromDropDownList(machineType);
        machineTypeUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage addGPUs() {
        addGPUs.click();
        return this;
    }

    public GoogleCloudCalculatorPage setNumberOfGPUs(int numberOfGPUs) {
        WebElement numberOfGPUsList = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-model='listingCtrl.computeServer.gpuCount']")));
        numberOfGPUsList.click();
        WebElement numberOfGPUsUserChoice = chooseElementFromDropDownList(Integer.toString(numberOfGPUs));
        numberOfGPUsUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setGpuType(String gpuType) {
        WebElement gpuTypeList = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-model='listingCtrl.computeServer.gpuType']")));
        gpuTypeList.click();
        WebElement gpuTypeUserChoice = chooseElementFromDropDownList(gpuType);
        gpuTypeUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setLocalSSD(String localSSD) {
        localSsdList.sendKeys(Keys.ENTER);
        WebElement localSsdUserChoice = chooseElementFromDropDownList(localSSD);
        localSsdUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation(String dataCenterLocation) {
        WebElement dataCenterLocationList = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-model='listingCtrl.computeServer.location']")));
        dataCenterLocationList.click();
        WebElement dataCenterLocationUserChoice = chooseElementFromDropDownList(dataCenterLocation);
        dataCenterLocationUserChoice.click();
        return this;
    }

    public GoogleCloudCalculatorPage setCommitedUsage(String commitedUsage) {
        commitedUsageList.sendKeys(Keys.ENTER);
        WebElement commitedUsageUserChoice = chooseElementFromDropDownList(commitedUsage);
        commitedUsageUserChoice.click();
        return this;
    }

    public void addToEstimate() {
        addToEstimate.click();
    }

    private WebElement chooseElementFromDropDownList(String element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='md-select-menu-container md-active md-clickable']//md-option/div[contains(text(), '" + element + "')]")));
    }

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    // Utils
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
