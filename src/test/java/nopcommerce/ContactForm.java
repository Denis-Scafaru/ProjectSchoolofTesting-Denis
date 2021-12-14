package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactForm {

    @FindBy (id ="FullName")
    private WebElement fullNameInput;

    @FindBy (id ="Email")
    private WebElement emailinput;

    @FindBy (id = "Enquiry")
    private WebElement enquiryinput;

    @FindBy (name = "send-email")
    private WebElement submitButton;

    @FindBy ( xpath = "//*[@class = 'result']")
    private WebElement result;

    @FindBy(id = "FullName-error")
    private WebElement fullnameErrorMessage;

    @FindBy (id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(id = "Enquiry-error")
    private WebElement enquiryErrorMessage;

    protected WebDriver driver;

    public ContactForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterfullname(String fullName){
        fullNameInput.sendKeys(fullName);

    }
    public void addemail(String email){
        emailinput.sendKeys(email);

    }
    public void addenquiry (String enquiry) {
        enquiryinput.sendKeys(enquiry);
    }
    public void SubmitButton() {
        submitButton.click();

    }
    public void fillInContactForm (String full_name, String email, String enquiry){
        enterfullname(full_name);
        addemail(email);
        addenquiry(enquiry);
        SubmitButton();

    }

    public String getResult() {

        return result.getText();
    }
    public String getfullnameErrorMessage(){

        return fullnameErrorMessage.getText();
    }
    public String getEmailErrorMessage(){
        return emailErrorMessage.getText();

    }
    public String getEnquiryErrorMessage(){
        return enquiryErrorMessage.getText();

    }

}






