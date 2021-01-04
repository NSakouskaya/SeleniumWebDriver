package page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement textArea;

    @FindBy(id = "postform-name")
    private WebElement pasteTitle;

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='None']")
    private WebElement drdSyntaxHighlighting;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchSyntaxField;

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='Never']")
    private WebElement pasteExpirationField;

    @FindBy(xpath = "//ul[@id ='select2-postform-expiration-results']/li[3]")
    private WebElement drdPasteExpiration;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPaste;

    public SeleniumHomePage(WebDriver driver) {
        super(driver);
    }

    public SeleniumHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.urlToBe("https://pastebin.com/"));
        return this;
    }

    public void inputCode(String code) {
        textArea.sendKeys(code);
    }

    public void inputTitle(String title) {
        pasteTitle.sendKeys(title);
    }

    public void clickDrdSyntaxHighlighting() {
        drdSyntaxHighlighting.click();
    }

    public void inputSyntaxHighlightingValue(String syntaxHighlighting) {
        searchSyntaxField.sendKeys(syntaxHighlighting);
        searchSyntaxField.sendKeys(Keys.ENTER);
    }

    public void clickPasteExpiration() {
        pasteExpirationField.click();
    }

    public void setUpPasteExpirationValue() {
        drdPasteExpiration.click(); }

        public void clickOnCreateNewPasteButton(){
            buttonCreateNewPaste.click();
        }
    }
