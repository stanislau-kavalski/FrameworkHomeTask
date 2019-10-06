package by.course.framework.page;

import by.course.framework.model.GpuData;
import by.course.framework.model.InstancesData;
import by.course.framework.model.MachineData;
import by.course.framework.model.OtherData;
import by.course.framework.service.GpuDataCreator;
import by.course.framework.service.InstancesDataCreator;
import by.course.framework.service.MachineDataCreator;
import by.course.framework.service.OtherDataCreator;
import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private static final String NUMBER_OF_GPU_LIST_XPATH = "//*[@ng-model='listingCtrl.computeServer.gpuCount']";
    private static final String GPU_TYPE_LIST_XPATH = "//*[@ng-model='listingCtrl.computeServer.gpuType']";
    private static final String DATA_CENTER_LOCATION_LIST_XPATH = "//*[@ng-model='listingCtrl.computeServer.location']";
    private static final String ELEMENT_IN_DROP_DOWN_LIST_XPATH = "//*[@class='md-select-menu-container md-active md-clickable']//md-option/div[contains(text(), '%s')]";

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

    private void switchToIframe() {
        driver.switchTo().frame(iFrame);
}

    private void selectComputeEngine() {
        computeEngineSectionBtn.click();
    }

    private void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances.sendKeys(Integer.toString(numberOfInstances));
    }

    private void setWhatAreTheseInstanceFor(String instancesFor) {
        whatAreTheseInstanceFor.sendKeys(instancesFor);
    }

    private void setOperationSystemOrSoftware(String operationSystem) {
        operationSystemOrSoftwareList.click();
        WebElement operationSystemUserChoice = findElementInDropDownList(operationSystem);
        operationSystemUserChoice.click();
    }

    private void setMachineClass(String machineClass) {
        machineClassList.sendKeys(Keys.ENTER);
        WebElement machineClassUserChoice = findElementInDropDownList(machineClass);
        machineClassUserChoice.click();
    }

    private void setMachineType(String machineType) {
        BrowserUtils.scrollToElement(driver, machineTypeList);
        machineTypeList.sendKeys(Keys.ENTER);
        WebElement machineTypeUserChoice = findElementInDropDownList(machineType);
        machineTypeUserChoice.click();
    }

    private void addGPUs() {
        addGPUs.click();
    }

    private void setNumberOfGPUs(int numberOfGPUs) {
        WebElement numberOfGPUsList = waitUntilPresenceOfElementLocatedByXpath(NUMBER_OF_GPU_LIST_XPATH);
        numberOfGPUsList.click();
        WebElement numberOfGPUsUserChoice = findElementInDropDownList(Integer.toString(numberOfGPUs));
        numberOfGPUsUserChoice.click();
    }

    private void setGpuType(String gpuType) {
        WebElement gpuTypeList = waitUntilPresenceOfElementLocatedByXpath(GPU_TYPE_LIST_XPATH);
        gpuTypeList.click();
        WebElement gpuTypeUserChoice = findElementInDropDownList(gpuType);
        gpuTypeUserChoice.click();
    }

    private void setLocalSSD(String localSSD) {
        localSsdList.sendKeys(Keys.ENTER);
        WebElement localSsdUserChoice = findElementInDropDownList(localSSD);
        localSsdUserChoice.click();
    }

    private void setDataCenterLocation(String dataCenterLocation) {
        WebElement dataCenterLocationList = waitUntilPresenceOfElementLocatedByXpath(DATA_CENTER_LOCATION_LIST_XPATH);
        dataCenterLocationList.click();
        WebElement dataCenterLocationUserChoice = findElementInDropDownList(dataCenterLocation);
        dataCenterLocationUserChoice.click();
    }

    private void setCommitedUsage(String commitedUsage) {
        commitedUsageList.sendKeys(Keys.ENTER);
        WebElement commitedUsageUserChoice = findElementInDropDownList(commitedUsage);
        commitedUsageUserChoice.click();
    }

    private void addToEstimate() {
        addToEstimate.click();
    }

    public GoogleCloudCalculatorEstimatePage fillComputeEngineForm() {
        InstancesData instancesData = InstancesDataCreator.withCredentialsFromProperty();
        MachineData machineData = MachineDataCreator.withCredentialsFromProperty();
        GpuData gpuData = GpuDataCreator.withCredentialsFromProperty();
        OtherData otherData = OtherDataCreator.withCredentialsFromProperty();
        switchToIframe();
        selectComputeEngine();
        setNumberOfInstances(instancesData.getNumberOfInstances());
        setWhatAreTheseInstanceFor(instancesData.getForWhatInstance());
        setOperationSystemOrSoftware(otherData.getOperationSystemAndSoftware());
        setMachineClass(machineData.getMachineClass());
        setMachineType(machineData.getMachineType());
        addGPUs();
        setNumberOfGPUs(gpuData.getNumberOfGPU());
        setGpuType(gpuData.getGpuType());
        setLocalSSD(otherData.getLocalSSD());
        setDataCenterLocation(otherData.getDataCenterLocation());
        setCommitedUsage(otherData.getCommitedUsage());
        addToEstimate();
        return new GoogleCloudCalculatorEstimatePage(driver);
    }

    private WebElement findElementInDropDownList(String element) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ELEMENT_IN_DROP_DOWN_LIST_XPATH, element))));
    }

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }
}
