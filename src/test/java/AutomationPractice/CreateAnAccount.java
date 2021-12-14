package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Range.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CreateAnAccount {
//    @FindBy (name = "id_gender1")
//    public WebElement MrButton;
//    @FindBy (id = "id_gender2")
//    public WebElement MrsButton;
    @FindBy (className = "radio-inline")
    private List<WebElement> selectGender;
    @FindBy (id="customer_firstname")
    private WebElement firstNameInput;
    @FindBy (id="customer_lastname")
    private WebElement lastNameInput;
    @FindBy (id="email")
    private WebElement emailinput;
    @FindBy(id="passwd")
    private WebElement passwordinput;
    @FindBy(id = "days")
    private WebElement dayOfBirthDropDown;
    @FindBy(id = "months")
    private WebElement monthOfBirthDropdown;
    @FindBy(id = "years")
    private WebElement yearOfBirthDropdown;
    @FindBy(id = "newsletter")
    private WebElement newslettercheckbox;
    @FindBy(id = "optin")
    private WebElement specialOffersCheckBox;
    @FindBy(id="company")
    private WebElement companyInput;
    @FindBy (id="address1")
    private WebElement adressInput;
    @FindBy (id="address2")
    private WebElement adressInput2;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    public WebElement americaStateDropDown;
    @FindBy(id = "postcode")
    public WebElement postalCodeInput;

    @FindBy (id ="id_country")
    public WebElement selectCountry;
    @FindBy(id = "phone")
    public WebElement homePhoneInput;
    @FindBy(id = "phone_mobile")
    public WebElement phoneMobileInput;
    @FindBy(id = "alias")
    public WebElement adressInputReferences;
    @FindBy(id="submitAccount")
    public WebElement submitAccountButton;
    @FindBy(id="other")
    public WebElement otherInfo;
    @FindBy(xpath = "//*[contains(@class, 'alert alert-danger')][1]")
    public WebElement errorMessages;


    protected WebDriver driver;
    public CreateAnAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
    public void fillInRegistrationForm (String firstname, String lastName, String password, String company, String address, String address2, String city, String postcode, String otherInformation,String homePhone,String phoneNumber, String adressReferences){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(visibilityOf(submitAccountButton));
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastName);
        passwordinput.sendKeys(password);
        companyInput.sendKeys(company);
        adressInput.sendKeys(address);
        adressInput2.sendKeys(address2);
        cityInput.sendKeys(city);
        postalCodeInput.sendKeys(postcode);
        otherInfo.sendKeys(otherInformation);
        homePhoneInput.sendKeys(homePhone);
        phoneMobileInput.sendKeys(phoneNumber);
        adressInputReferences.sendKeys(adressReferences);
    }

    public void setGender (String gender){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(visibilityOf(submitAccountButton));
        if(gender.equalsIgnoreCase("mr."))
            selectGender.get(0).click();
        else if (gender.equalsIgnoreCase("mrs."))
            selectGender.get(1).click();

    }

    public void selectDayOfBirth(String value){
            Select drop = new Select(dayOfBirthDropDown);
            drop.selectByValue(value);
        }
    public void selectMonthOfBirth(String value){
        Select drop = new Select(monthOfBirthDropdown);
        drop.selectByValue(value);
    }
    public void selectYearOfBirth(String year){
        Select drop = new Select(yearOfBirthDropdown);
        if (Integer.parseInt(year) <= 2003) {
            drop.selectByValue(year);
        }
        else {
            assertThat(Integer.parseInt(year), is(lessThan(2004)));
        }
    }
    public void selectNewsletterCheckBox(){
        if (!newslettercheckbox.isSelected())
            newslettercheckbox.click();
    }
    public void selectOfferCheckBox(){
        if (!specialOffersCheckBox.isSelected())
            specialOffersCheckBox.click();
    }
    public void selectState(String value){
        Select drop = new Select(americaStateDropDown);
        drop.selectByVisibleText(value);
    }
    public void setSelectCountry(String value){
        Select drop = new Select(selectCountry);
        drop.selectByVisibleText(value);
    }
    public String getResultError() {
        return errorMessages.getText();

    }
}





