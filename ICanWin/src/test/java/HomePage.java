import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "input_text")
    private WebElement textArea;

    @FindBy(id = "paste_title")
    private WebElement pasteName;

    @FindBy(xpath = "//div[@class='rte-menu' and @title='Change Font Size']")
    private WebElement drpChangeFontSize;

    @FindBy(id="rte-menu-sizes")
    private WebElement listOfFonts;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement buttonCreateNewPaste;

    public void inputCode(String code) {
        textArea.sendKeys(code);
    }

    public void inputTitle(String title) {
        pasteName.sendKeys(title);
    }

    public void openChangeSizeList (){
        drpChangeFontSize.click();
    }

    public void selectSizeValue (){
        WebElement ele = listOfFonts.findElement(By.xpath("//*[@id='rte-menu-sizes']/div[6]/font"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    }
        public void clickOnCreateNewPasteButton() {
        buttonCreateNewPaste.click();
        }

}