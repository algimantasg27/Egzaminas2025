package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;

public class CalculatorAppPage extends BasePage{

    @FindBy (css = "#sk1")
    private WebElement inputNumber1;

    @FindBy (css = "#sk2")
    private WebElement inputNumber2;

    @FindBy (xpath = "//*[@id=\"number\"]/select")
    private WebElement function;

    @FindBy (xpath = "//*[@id=\"number\"]/input[3]")
    private WebElement buttonSubmit;

    @FindBy (xpath = "//*[@id=\"sk2.errors\"]")
    private WebElement validationText;

    @FindBy (xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement buttonLogOut;

    @FindBy (xpath = "/html/body/div/form/div/span[1]")
    private WebElement logOutMessage;


    public CalculatorAppPage(WebDriver driver) {
        super(driver);
    }

    public void setInputNumber1(String input) {
        inputNumber1.click();
        inputNumber1.sendKeys(Keys.BACK_SPACE);
        inputNumber1.sendKeys(input);
    }

    public void setInputNumber2(String input) {
        inputNumber2.click();
        inputNumber2.sendKeys(Keys.BACK_SPACE);
        inputNumber2.sendKeys(input);
    }

    public void setMinusFunction() {
        function.click();
        Select subject = new Select(function);
        subject.selectByValue("-");
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public String getUrl() {

//        String hrefValue = driver.getTitle();
//        String urlValue = driver.getCurrentUrl();
        return  driver.getCurrentUrl();


    }

    public String getValidationText() {
        return validationText.getText();
    }

    public void clickButtonLogOut() {
        buttonLogOut.click();
    }

    public String getLogOutMessage() {
        return logOutMessage.getText();
    }

}
