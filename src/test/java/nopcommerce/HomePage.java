package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    @FindBy(xpath ="//button[contains(@class, 'product-box-add-to-cart-button')]")
    private List<WebElement> addToCartButtons;


    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public buildYourOwnComputer gotobuildYourOwnComputer (){
        addToCartButtons.get(0).click();
        return new buildYourOwnComputer(driver);

    }

}
