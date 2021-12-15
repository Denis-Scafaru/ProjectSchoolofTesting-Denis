package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAutomation {
    @FindBy(className = "login")
    public WebElement signInButton;

    private WebDriver driver;

    public HomePageAutomation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage goToSignInPage (){
        signInButton.click();
        return new SignInPage(driver);

    }

    public void SubmitButton(){
        signInButton.click();
    }
}
