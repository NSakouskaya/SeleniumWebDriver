package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WebDriverSeleniumCheckEmail {

    private WebDriver driver;
    public static final String GENERATE_EMAIL_URL = "https://10minutemail.com";

    @BeforeMethod(alwaysRun = true)

    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkTotalPriceOnEmail() {

        String searchValue1 = "Google Cloud Platform Pricing Calculator";

        SeleniumStartPage startPage = new SeleniumStartPage(driver);

        startPage.openPage();
        startPage.clickSearchButton();
        startPage.inputValueForSearch(searchValue1);

        SeleniumSearchResultsPage searchResultsPage = new SeleniumSearchResultsPage(driver);

        searchResultsPage.clickOnLink();

        SeleniumCalculatorPage calculatorPage = new SeleniumCalculatorPage(driver);

        calculatorPage.openPage();

        ChildFramePage frame = calculatorPage.frame();

        calculatorPage.fillInNumberOfInstancesField("4");
        calculatorPage.setUpOperatingSystemDrp();
        calculatorPage.setUpMachineClassDrp();
        calculatorPage.setUpMachineTypeDrp();
        calculatorPage.setUpDataCenterLocationDrp(0);
        calculatorPage.setUpCommittedUsageDrp(0);
        calculatorPage.clickAddToEstimateButton(calculatorPage.firstButton);
        calculatorPage.fillInNumberOfNodesField("2");
        calculatorPage.checkAddGPUsCheckbox();
        calculatorPage.setUpNumberOfGPUsDrp();
        calculatorPage.setUpTypeGPUDrp();
        calculatorPage.setUpLocalSSDDrp();
        calculatorPage.setUpDataCenterLocationDrp(1);
        calculatorPage.setUpCommittedUsageDrp(1);
        calculatorPage.clickAddToEstimateButton(calculatorPage.secondButton);

        GenerateEmailPage generateEmailPage = new GenerateEmailPage(driver);

        //Open URL in new TAB
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(GENERATE_EMAIL_URL);

        //click on 'Copy address' button
        generateEmailPage.clickCopyAddressButton();

        //switch to Calculator Page/EstimateResultsPage
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        WebElement frame1 = driver.findElement(By.id("myFrame"));
        driver = driver.switchTo().frame(frame1);

        //click Button for loading POP-UP
        EstimateResultsPage resultsPage = new EstimateResultsPage(driver);
        resultsPage.clickEmailEstimateButton();
        //get value for assert
        resultsPage.getTotalEstimate();
        //find 'Email' field on POP-UP , past copied email and send form
        resultsPage.pasteEmailAddress();
        resultsPage.clickSendButton();

        //open site with email, wait and open email
        driver.switchTo().window(tabs.get(1));


        new WebDriverWait(driver, 20)
                .until(visibilityOfElementLocated(By.xpath("//*[@id='mail_messages']")));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('mail_messages').scrollIntoView();");

        generateEmailPage.clickEmailBox();

        //check email and compare total price

        WebElement emailPrice = driver.findElement(By.xpath("//table/descendant-or-self::h3[last()]"));
        String textTotal = emailPrice.getText();
        //System.out.println(textTotal);

        Assert.assertTrue(resultsPage.getTotalEstimate().contains(textTotal));
        System.out.println("true");

//        driver.switchTo().window(tabs.get(0));
//
//        WebElement totalPrice = driver.findElement(By.xpath("//*[@id='resultBlock']/descendant-or-self::h2[4]"));

        //    @AfterMethod(alwaysRun = true)
//    public void browserDown() {
//        driver.quit();
//    }

    }
}
