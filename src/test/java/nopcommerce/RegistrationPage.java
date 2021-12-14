package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationPage {
    @FindBy(name = "Gender")
    private List<WebElement> genderRadioButtons;
    @FindBy(id = "FirstName")
    private WebElement inputFirstName;
    @FindBy(id= "LastName")
    private WebElement inputLastName;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dayOfBirthDropdown;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthOfBirthDropdown;
    @FindBy(name = "DateOfBirthYear")
    private WebElement YearOfBirthDropdown;
    @FindBy (id = "Email")
    private WebElement inputEmail;
    @FindBy (id = "Company")
    private WebElement inputCompany;
    @FindBy (id = "Password")
    private WebElement inputPassword;
    @FindBy (id = "ConfirmPassword")
    private WebElement confirmInputPassword;
    @FindBy (id = "Newsletter")
    private WebElement newsletterCheckBox;
    @FindBy (id = "register-button")
    private WebElement registerButton;
    @FindBy (xpath = "//*[@class = 'result']")
    private WebElement result;
    @FindBy (className = "ico-logout")
    private WebElement logOutButton;
    @FindBy (className = "ico-login")
    private WebElement loginButton;

    protected WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//model1
    public void fillInRegistrationForm(String firstName, String lastName, String email, String company, String password, String confirmpassword){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputCompany.sendKeys(company);
        inputPassword.sendKeys(password);
        confirmInputPassword.sendKeys(confirmpassword);
        //registerButton.click();


    }
//model 2 (e mai lung asta ca scriu metodele separat)
    public void enterFirstName (String firstName){
        inputFirstName.sendKeys(firstName);
    }
    public void enterLastName (String lastName){

        inputLastName.sendKeys(lastName);
    }
    public void enterEmail (String email){

        inputEmail.sendKeys(email);
    }
    public void enterCompanyInput(String company){

        inputCompany.sendKeys(company);
    }

    public void enterpasswordInput(String password){
        confirmInputPassword.sendKeys(password);

    }
    public void confirmpasswordInput(String password){

        inputPassword.sendKeys(password );
    }

    public void setGender (String gender){
        if(gender.equalsIgnoreCase("male"))
        genderRadioButtons.get(0).click();
        else if (gender.equalsIgnoreCase("female"))
            genderRadioButtons.get(1).click();
    }
    public void selectDayofBirth(String day){
        Select dropDownDob= new Select(dayOfBirthDropdown);
        dropDownDob.selectByVisibleText(day);
    }
    public void selectMonthofBirth(String month){
        Select dropDownMob= new Select(monthOfBirthDropdown);
        dropDownMob.selectByVisibleText(month);
    }

    public void selectYearofBirth(String year){
        Select dropDownYob= new Select(YearOfBirthDropdown);
        dropDownYob.selectByVisibleText (year);
    }
    public void logOut (){

        logOutButton.click();
    }
    public LoginPage gotoLoginPage(){
        loginButton.click();
        return new LoginPage(driver);
    }

    public void selectNewsletterCheckBox(){
        if (!newsletterCheckBox.isSelected())
            newsletterCheckBox.click();
    }
    public void registerButton (){

        registerButton.click();
    }
    public String getresult(){
        return result.getText();

    }


}

