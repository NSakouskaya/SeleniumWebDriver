import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillInRequiredFieldsForCreatingNewPaste() {

        TestHome testHome = new TestHome(driver);

//        String title = "helloweb";
//        String code = "Hello from WebDriver";
//        String high = "Bash";
        //String title = "how to gain dominance among developers";

        String title =
                "git config --global user.name  'New Sheriff in Town'\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
                        "git push origin master --force";


                driver.get("https://pastebin.com/4pH3wzp9");
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://pastebin.com/4pH3wzp9"));

        //testHome.headerClick();
        testHome.getHeaderName();
        String headerName = testHome.getHeaderName();
        Assert.assertEquals(headerName, title);


//        testHome.clickDrd();
//        testHome.inputHigh(high);
//        testHome.pressEnterKey();
//        testHome.clickPasteExpiration();
//        testHome.setUpPasteExpirationValue("10M");

//        testHome.inputTitle(title);
//        testHome.inputCode(code);
//        testHome.setUpCodeHighlighting("Yes");
        //testHome.clickOnCreateNewPasteButton();
    }
//
//    @AfterMethod(alwaysRun = true)
//    public void browserDown() {
//        driver.quit();
//    }

}
