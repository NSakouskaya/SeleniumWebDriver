package page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class EstimateResultsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[2]")
    private WebElement classVM;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[3]")
    private WebElement instanceType;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[4]")
    private WebElement computeRegion;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[5]")
    private WebElement tenantCommittedTerm;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[3]")
    private WebElement coleTenantRegion;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[4]")
    private WebElement nodeCommittedTerm;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[7]")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id='resultBlock']/descendant-or-self::h2[4]")
    private WebElement totalEstimate;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendButton;

    public EstimateResultsPage(WebDriver driver) {
        super(driver);
    }
    public AbstractPage openPage() {
        return null;
    }

    public String getClassVM() {
        return classVM.getText();
    }


    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getComputeRegion() {
        return computeRegion.getText();
    }

    public String getTenantCommittedTerm() {
        return tenantCommittedTerm.getText();
    }

    public String getColeTenantRegion() {
        return coleTenantRegion.getText();
    }

    public String getNodeCommittedTerm() {
        return nodeCommittedTerm.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getTotalEstimate() {
        return totalEstimate.getText();
    }

    public void clickEmailEstimateButton(){
        new WebDriverWait(driver, 10)
                .until(visibilityOfElementLocated(By.xpath("//button[@id='email_quote']")));
        emailEstimateButton.click(); }


    public void pasteEmailAddress(){
        new WebDriverWait(driver, 20)
                .until(visibilityOfElementLocated(By.xpath("//*[@name='emailForm']/descendant-or-self::h2")));
        emailInput.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v"));}

    public void clickSendButton(){ sendButton.click(); }
}
