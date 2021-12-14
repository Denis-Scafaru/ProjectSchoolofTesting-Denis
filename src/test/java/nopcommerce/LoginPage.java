package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="Email")
    private WebElement emailInput;
    @FindBy(id="Password")
    private WebElement passwordInput;
    @FindBy(css ="button.login-button")
    private WebElement logInButton;

    private WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver, this);
    }

    public void completeLogInPage(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logInButton.click();
    }
}
