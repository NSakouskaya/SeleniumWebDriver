package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ChildFramePage;
import page.EstimateResultsPage;
import page.SeleniumCalculatorPage;

public class WebDriverSeleniumCalculatePrice {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void calculateGoogleCloudPrice() {

        String searchValue1 = "Google Cloud Platform Pricing Calculator";

        page.SeleniumStartPage startPage = new page.SeleniumStartPage(driver);

        startPage.openPage();
        startPage.clickSearchButton();
        startPage.inputValueForSearch(searchValue1);

        page.SeleniumSearchResultsPage searchResultsPage = new page.SeleniumSearchResultsPage(driver);

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

        EstimateResultsPage resultsPage = new EstimateResultsPage(driver);

        Assert.assertEquals("VM class: regular", resultsPage.getClassVM());
        Assert.assertEquals("Instance type: e2-standard-8", resultsPage.getInstanceType());
        Assert.assertEquals("Region: Frankfurt", resultsPage.getComputeRegion());
        Assert.assertEquals("Commitment term: 1 Year", resultsPage.getTenantCommittedTerm());
        Assert.assertEquals("Region: Frankfurt", resultsPage.getColeTenantRegion());
        Assert.assertEquals("Commitment term: 1 Year", resultsPage.getNodeCommittedTerm());
        Assert.assertEquals("Total available local SSD space 24x375 GiB", resultsPage.getLocalSSD());
        Assert.assertEquals("Total Estimated Cost: USD 9,623.94 per 1 month", resultsPage.getTotalEstimate());
    }
//
//    @AfterMethod(alwaysRun = true)
//    public void browserDown() {
//        driver.quit();
//    }
}
