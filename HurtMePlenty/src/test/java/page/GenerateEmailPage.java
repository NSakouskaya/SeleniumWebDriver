package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GenerateEmailPage {

    protected WebDriver driver;

    public static final String GENERATE_EMAIL_URL = "https://10minutemail.com";

    public GenerateEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copyAddressButton;

    @FindBy(xpath = "//*[@id='mail_messages_content']")
    private WebElement emailBox;

    public void clickCopyAddressButton(){
        new WebDriverWait(driver, 20)
                .until(visibilityOfElementLocated(By.xpath("//div[@id='copy_address']")));
        copyAddressButton.click(); }

    public void clickEmailBox(){
        new WebDriverWait(driver, 20)
                .until( h -> h.findElement(By.xpath("//div[@class='mail_message']")) != null);
        emailBox.click(); }


}
