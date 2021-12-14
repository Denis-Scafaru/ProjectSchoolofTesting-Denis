package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SignInPage {
    @FindBy (id="email_create")
    public WebElement emailinput;

    @FindBy (id = "SubmitCreate")
    public WebElement submitButton;

    @FindBy (id = "create_account_error")
    public WebElement emailError;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterEmail (String email) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(elementToBeClickable(emailinput));
        emailinput.sendKeys(email);
    }
    public CreateAnAccount redirectPage(){
        submitButton.click();
        return new CreateAnAccount(driver);
    }
    public String EmailError(){
        return emailError.getText();
    }
    }
