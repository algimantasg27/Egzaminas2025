package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    @FindBy(xpath = "/html/body/div/form/div/h4/a")
    private WebElement registerPage;

    @FindBy(xpath = "/html/body/div/form/div/input[1]")
    private WebElement inputUsername;

    @FindBy (xpath = "/html/body/div/form/div/input[2]")
    private WebElement inputPassword;

    @FindBy (xpath = "/html/body/div/form/div/button")
    private WebElement buttonSubmit;

    @FindBy (xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement username;

    @FindBy (xpath = "/html/body/div/form/div/span[2]")
    private WebElement errorMessage;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterPage() {
        registerPage.click();
    }

    public void enterUsername(String value) {
        inputUsername.sendKeys(value);
    }

    public void enterPassword(String value) {
        inputPassword.sendKeys(value);
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
