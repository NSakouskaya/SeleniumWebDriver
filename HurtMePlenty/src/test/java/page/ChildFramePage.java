package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChildFramePage {

    protected WebDriver driver;

    @FindBy(xpath = "//*[@name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[starts-with(@aria-label, 'Operating System')]/md-select-value")
    private WebElement operatingSystemDrp;

//    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]/md-select-value")
//    private WebElement machineClassDrp;

//    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]/md-select-value")
//    private WebElement machineTypeDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Datacenter location')]/md-select-value")
   private List<WebElement> dataCenterDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Committed usage')]/md-select-value")
    private List<WebElement> committedUsageDrp;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private List<WebElement> estimateButton;

    @FindBy(xpath = "//input[@name='nodesCount']")
    private WebElement numberOfNodesField;

    @FindBy(xpath = "//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[starts-with(@aria-label, 'Number of GPUs')]/md-select-value")
    private WebElement numberOfGPUsDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'GPU type')]/md-select-value")
    private WebElement typeGPUDrp;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']/md-select-value")
    private WebElement localSSDDrp;


    protected ChildFramePage(WebDriver driver) {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='quantity']")));
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement instancesInput() {
        return  this.numberOfInstancesField;
    }

    public WebElement softwareDropDown() {
        return  this.operatingSystemDrp;
    }

//    public WebElement machineClassDropDown() { return  this.machineClassDrp; }

//    public WebElement machineTypeDropDown() {
//        return  this.machineTypeDrp;
//    }

    public WebElement dataCenterDropDown(int index) {
        return  this.dataCenterDrp.get(index);
    }

    public WebElement committedUsageDropDown(int index) {
        return  this.committedUsageDrp.get(index);
    }

    public WebElement nodesInput() {
        return  this.numberOfNodesField;
    }

    public WebElement checkboxGPUs() { return  this.addGPUsCheckbox; }

    public WebElement clickToEstimateButton(int index) { return  this.estimateButton.get(index); }

    public WebElement numberGPUsDropDown() { return  this.numberOfGPUsDrp; }

    public WebElement typeGPUDropDown() {
        return  this.typeGPUDrp;
    }

    public WebElement setLocalSSdDropDown() {
        return  this.localSSDDrp;
    }

    public void setupDropdownValue(String cssClass, String value) {
        String propDownXPath = String.format("//md-select[contains(@aria-label, '%s')]/md-select-value", cssClass);
        WebElement mc = driver.findElement(By.xpath(propDownXPath));
        mc.click();
        WebElement selectedValue = getOptionByValue(value);
        selectedValue.click();
    }

    private WebElement getOptionByValue(String value) {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='%s']", value))));
    }
}
