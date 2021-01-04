import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumCreatingNewPasteTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillInRequiredFieldsForCreatingNewPaste() {

        String title = "helloweb";
        String code = "Hello from WebDriver";

        driver.get("https://controlc.com/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://controlc.com/"));

        HomePage homePage = new HomePage(driver);

        homePage.openChangeSizeList();
        homePage.selectSizeValue();
        homePage.inputCode(code);
        homePage.inputTitle(title);
        //homePage.clickOnCreateNewPasteButton();
    }

//       @AfterMethod(alwaysRun = true)
//    public void browserDown() {
//        driver.quit();
//       }

}
