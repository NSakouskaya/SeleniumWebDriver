package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumResultsPage extends AbstractPage {

    @FindBy(xpath = "//div/descendant-or-self::h1")
    private WebElement header;

    @FindBy(xpath = "//ol[li]")
    private WebElement code;

    public SeleniumResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderName() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='highlighted-code']")));

        String headerName = header.getText();
        return headerName;
    }

    public String getCodeText() {
        String color = code.findElement(By.xpath("//li[1]//span[1]")).getCssValue("color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

    public String getFontColor() {
        String color = code.findElement(By.xpath("//li[1]//span[3]")).getCssValue("color"); //expected result: #ff0000
        String hex = Color.fromString(color).asHex();
        return hex;
    }

    protected AbstractPage openPage() {
        return null;
    }
}
