package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy (css = "#username")
    private WebElement inputUsername;

    @FindBy (css = "#password")
    private WebElement inputPassword;

    @FindBy (css = "#passwordConfirm")
    private WebElement inputPasswordConfirm;

    @FindBy (xpath = "//*[@id=\"userForm\"]/button")
    private WebElement buttonSubmit;

    @FindBy (xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement username;

    @FindBy (xpath = "//*[@id=\"passwordConfirm.errors\"]")
    private WebElement passwordConfirmText;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterInputUsername(String value) {
        inputUsername.sendKeys(value);
    }

    public void enterInputPassword(String value) {
        inputPassword.sendKeys(value);
    }

    public void enterInputPasswordConfirm(String value) {
        inputPasswordConfirm.sendKeys(value);
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPasswordConfirmTexts() {
        return passwordConfirmText.getText();
    }
}
