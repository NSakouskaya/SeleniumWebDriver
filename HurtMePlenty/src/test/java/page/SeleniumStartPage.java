package page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumStartPage extends AbstractPage {

    public static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//form[@class = 'devsite-search-form']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;


    public SeleniumStartPage (WebDriver driver)  {
        super(driver);
    }

    public SeleniumStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
               .until(presenceOfElementLocated(By.xpath("//form[@class = 'devsite-search-form']")));
        return this;
    }

    public void clickSearchButton(){ searchButton.click(); }
    public void inputValueForSearch (String searchValue1){
        searchField.sendKeys(searchValue1);
        searchField.sendKeys(Keys.ENTER);
    }

}
