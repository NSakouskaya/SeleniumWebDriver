import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SeleniumHomePage;
import page.SeleniumResultsPage;

public class WebDriverSeleniumCreatePaste {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste() {

        SeleniumHomePage homePage = new SeleniumHomePage(driver);

        String title = "how to gain dominance among developers";
        String code = "git config --global user.name 'New Sheriff in Town'\n" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
                "git push origin master --force/n";
        String color1 = "#c20cb9";
        String color2 = "#ff0000";

        homePage.openPage();
        homePage.clickDrdSyntaxHighlighting();
        homePage.inputSyntaxHighlightingValue("Bash");
        homePage.clickPasteExpiration();
        homePage.setUpPasteExpirationValue();
        homePage.inputCode(code);
        homePage.inputTitle(title);
        homePage.clickOnCreateNewPasteButton();

        SeleniumResultsPage resultsPage = new SeleniumResultsPage(driver);
        String headerName = resultsPage.getHeaderName();
        Assert.assertEquals(headerName, title);
        Assert.assertEquals(resultsPage.getCodeText(), color1);
        Assert.assertEquals(resultsPage.getFontColor(), color2);
    }

        //@AfterMethod(alwaysRun = true)
//    public void browserDown() {
//        driver.quit();
//    }

    }
