package by.course.framework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

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

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPage switchToCalculatorFormIframe() {
        getDriver().switchTo().frame(iFrame);
        return this;
    }

    public void clickComputeEngine() {
        clickOnWebElement(computeEngineSectionBtn);
    }

    public GoogleCloudCalculatorPage setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public void setWhatAreTheseInstanceFor(String instancesFor) {
        whatAreTheseInstanceFor.sendKeys(instancesFor);
    }

    public GoogleCloudCalculatorPage setOperationSystemOrSoftware(String operationSystem) {
        clickOnWebElement(operationSystemOrSoftwareList);
        chooseElementInDropDownList(operationSystem);
        return this;
    }

    public GoogleCloudCalculatorPage setMachineClass(String machineClass) {
        clickOnWebElement(machineClassList);
        chooseElementInDropDownList(machineClass);
        return this;
    }

    public void setMachineType(String machineType) {
        clickOnWebElement(machineTypeList);
        chooseElementInDropDownList(machineType);
    }

    public GoogleCloudCalculatorPage clickAddGpu() {
        clickOnWebElement(addGPUs);
        return this;
    }

    public GoogleCloudCalculatorPage setNumberOfGPUs(int numberOfGPUs) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(NUMBER_OF_GPU_LIST_XPATH));
        chooseElementInDropDownList(Integer.toString(numberOfGPUs));
        return this;
    }

    public void setGpuType(String gpuType) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(GPU_TYPE_LIST_XPATH));
        chooseElementInDropDownList(gpuType);
    }

    public void setLocalSSD(String localSSD) {
        clickOnWebElement(localSsdList);
        chooseElementInDropDownList(localSSD);
    }

    public GoogleCloudCalculatorPage setDataCenterLocation(String dataCenterLocation) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(DATA_CENTER_LOCATION_LIST_XPATH));
        chooseElementInDropDownList(dataCenterLocation);
        return this;
    }

    public void setCommitedUsage(String commitedUsage) {
        clickOnWebElement(commitedUsageList);
        chooseElementInDropDownList(commitedUsage);
    }

    public GoogleCloudCalculatorEstimatePage clickAddToEstimate() {
        clickOnWebElement(addToEstimate);
        return new GoogleCloudCalculatorEstimatePage(getDriver());
    }

    private void chooseElementInDropDownList(String elementXpath) {
        waitUntilPresenceOfElementLocatedAndClick(By.xpath(String.format(ELEMENT_IN_DROP_DOWN_LIST_XPATH, elementXpath)));
    }
}
