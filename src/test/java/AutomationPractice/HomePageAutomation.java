package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePageAutomation {
    @FindBy(className = "login")
    public WebElement signInButton;

    private WebDriver driver;

    public HomePageAutomation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage goToSignInPage (){
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(visibilityOf(signInButton));
        signInButton.click();
        return new SignInPage(driver);

    }
}


