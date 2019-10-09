package by.course.framework.page;

import by.course.framework.model.GpuData;
import by.course.framework.model.InstancesData;
import by.course.framework.model.MachineData;
import by.course.framework.model.OtherCalculatorData;
import by.course.framework.service.GpuDataCreator;
import by.course.framework.service.InstancesDataCreator;
import by.course.framework.service.MachineDataCreator;
import by.course.framework.service.OtherCalculatorDataCreator;
import by.course.framework.test.GoogleCloudTest;
import by.course.framework.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorPage extends AbstractPage {
//Follow of modifiers
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

    public GoogleCloudTest switchToCalculatorFormIframe() {
        getDriver().switchTo().frame(iFrame);
        return new GoogleCloudTest();
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

    public GoogleCloudCalculatorPage setOperationSystemOrSoftware(String operationSystem) {
        operationSystemOrSoftwareList.click();
        chooseElementInDropDownList(operationSystem);
        return this;
    }

    private void setMachineClass(String machineClass) {
        machineClassList.sendKeys(Keys.ENTER);
        chooseElementInDropDownList(machineClass);
    }

    private void setMachineType(String machineType) {
        BrowserUtils.scrollToElement(getDriver(), machineTypeList);
        machineTypeList.sendKeys(Keys.ENTER);
        chooseElementInDropDownList(machineType);
    }

    private void addGPUs() {
        addGPUs.click();
    }

    private void setNumberOfGPUs(int numberOfGPUs) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(NUMBER_OF_GPU_LIST_XPATH));
        chooseElementInDropDownList(Integer.toString(numberOfGPUs));
    }

    private void setGpuType(String gpuType) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(GPU_TYPE_LIST_XPATH));
        chooseElementInDropDownList(gpuType);
    }

    public GoogleCloudCalculatorPage setLocalSSD(String localSSD) {
        localSsdList.sendKeys(Keys.ENTER);
        chooseElementInDropDownList(localSSD);
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation(String dataCenterLocation) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(DATA_CENTER_LOCATION_LIST_XPATH));
        chooseElementInDropDownList(dataCenterLocation);
        return this;
    }

    public void setCommitedUsage(String commitedUsage) {
        commitedUsageList.sendKeys(Keys.ENTER);
        chooseElementInDropDownList(commitedUsage);
    }

    private void addToEstimate() {
        addToEstimate.click();
    }

    //Split to serveral meaningful methods and don't do it on PAGE
//    public GoogleCloudCalculatorEstimatePage fillComputeEngineForm() {
//        InstancesData instancesData = InstancesDataCreator.withCredentialsFromProperty();
//        MachineData machineData = MachineDataCreator.withCredentialsFromProperty();
//        GpuData gpuData = GpuDataCreator.withCredentialsFromProperty();
//
//
//        selectComputeEngine();
//        setNumberOfInstances(instancesData.getNumberOfInstances());
//        setWhatAreTheseInstanceFor(instancesData.getForWhatInstance());
//
//        setMachineClass(machineData.getMachineClass());
//        setMachineType(machineData.getMachineType());
//        addGPUs();
//        setNumberOfGPUs(gpuData.getNumberOfGPU());
//        setGpuType(gpuData.getGpuType());
//        setLocalSSD(otherData.getLocalSSD());

//        addToEstimate();
//        return new GoogleCloudCalculatorEstimatePage(getDriver());
//    }

    private void chooseElementInDropDownList(String elementXpath) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(String.format(ELEMENT_IN_DROP_DOWN_LIST_XPATH, elementXpath)));
    }

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }
}
