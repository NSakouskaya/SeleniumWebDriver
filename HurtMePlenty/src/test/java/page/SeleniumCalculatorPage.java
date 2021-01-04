package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumCalculatorPage extends AbstractPage {

    private ChildFramePage myFrame;
    public static final int firstButton = 0;
    public static final int secondButton = 1;

    public SeleniumCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ChildFramePage frame() {
        return this.myFrame;
    }


    public SeleniumCalculatorPage openPage() {
              new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(visibilityOfElementLocated(By.id("gc-wrapper")));

        driver.switchTo().frame(0);

        WebElement frame1 = driver.findElement(By.id("myFrame"));
        myFrame = new ChildFramePage(driver.switchTo().frame(frame1));
        return this;
    }


    public void fillInNumberOfInstancesField(String numberOfInstances) {
        this.myFrame.instancesInput().sendKeys(numberOfInstances);
           }


    public void setUpOperatingSystemDrp() {
        WebElement os = this.myFrame.softwareDropDown();
        os.click();
        WebElement softwareList = driver.findElement(By.xpath("//div/descendant-or-self::md-option[@value='free']"));
        softwareList.click();
    }

    public void setUpMachineClassDrp() {
//        WebElement mc = this.myFrame.machineClassDropDown();
//        mc.click();
//        waitForElementLocated(driver, "//div[@aria-hidden='false']");
//        WebElement machineClassList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='regular']"));
//        machineClassList.click();

        this.myFrame.setupDropdownValue("VM Class", "regular");
    }

    public void setUpMachineTypeDrp() {

        this.myFrame.setupDropdownValue("Instance type", "CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8");
//        WebElement mt = this.myFrame.machineTypeDropDown();
//        mt.click();
//        waitForElementLocated(driver, "//div/descendant-or-self::md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']");
//        WebElement machineTypeList = driver.findElement(By.xpath("//div/descendant-or-self::md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']"));
//        machineTypeList.click();
    }

    public void setUpDataCenterLocationDrp(int index) {
        WebElement dc = this.myFrame.dataCenterDropDown(index);
        dc.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']/descendant-or-self::md-option[@value='europe-west3']");

        WebElement dataCenterList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='europe-west3']"));
        dataCenterList.click();
    }

    public void setUpCommittedUsageDrp(int index) {
        WebElement cu = this.myFrame.committedUsageDropDown(index);
        cu.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement committedUsageList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='1']"));
        committedUsageList.click();
    }

    public void fillInNumberOfNodesField(String numberOfNodes) {
        this.myFrame.nodesInput().sendKeys(numberOfNodes);
    }

    public void checkAddGPUsCheckbox() {
        waitForElementLocated(driver, "//div['@aria-checked=false']");
        this.myFrame.checkboxGPUs().click();
    }

    public void setUpNumberOfGPUsDrp() {
        waitForElementLocated(driver, "//div/md-input-container/md-select[@placeholder='Number of GPUs']");
        WebElement ng = this.myFrame.numberGPUsDropDown();
        ng.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement numberGPUsList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='4']"));
        numberGPUsList.click();
    }

    public void setUpTypeGPUDrp() {
        WebElement tg = this.myFrame.typeGPUDropDown();
        tg.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement typeGPUDList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='NVIDIA_TESLA_T4']"));
        typeGPUDList.click();
    }

    public void setUpLocalSSDDrp() {
        WebElement ls = this.myFrame.setLocalSSdDropDown();
        ls.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement localSSdList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='24']"));
        localSSdList.click();
    }

    public void clickAddToEstimateButton(int index){
        WebElement btn = this.myFrame.clickToEstimateButton(index);
        btn.isEnabled();
        try {
            btn.click();
        } catch (Exception ex) {
            System.err.println("Button not found by index: " + index + "; exception message: " + ex.getMessage());
        }

    }

}
