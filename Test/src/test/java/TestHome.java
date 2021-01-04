import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestHome {

    public WebDriver driver;

    public TestHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='None']")
    private WebElement drdHight;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='Never']")
    private WebElement pasteExpirationField;

    @FindBy(xpath = "//select[@id ='postform-expiration']")
    private WebElement drdPasteExpiration;

    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement header;

    public void clickDrd() {
        drdHight.click();
    }

    public void inputHigh(String high) {
        searchField.sendKeys(high);
    }

    public void pressEnterKey() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickPasteExpiration() {
        pasteExpirationField.click();
    }

    public void setUpPasteExpirationValue(String selectByValue) {
        Select pasteExpirationValue = new Select(drdPasteExpiration);
        pasteExpirationValue.selectByValue(selectByValue);}

    public String getHeaderName() {
        String headerName = header.getText();
        return headerName;
    }
    public void headerClick() {
        header.click();
    }


//    @FindBy(id = "input_text")
//    private WebElement textArea;
//
//    @FindBy(id = "paste_title")
//    private WebElement pasteName;
//
//    @FindBy(id = "codeSyntax")
//    private WebElement drpCodeHighlighting;

//    @FindBy(xpath = "//*[@class='btn btn-primary']")
//    private WebElement buttonCreateNewPaste;

//    public void inputCode(String code) {
//        textArea.sendKeys(code);
//    }
//
//    public void inputTitle(String title) {
//        pasteName.sendKeys(title);
//    }


//    public void setUpCodeHighlighting(String selectByText) {
//        Select codeHighlightingSelect = new Select(drpCodeHighlighting);
//        codeHighlightingSelect.selectByVisibleText(selectByText);
//    }
//        public void clickOnCreateNewPasteButton() {
//        buttonCreateNewPaste.click();
//        }

    }
