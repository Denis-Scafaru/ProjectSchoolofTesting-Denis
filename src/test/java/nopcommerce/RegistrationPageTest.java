package nopcommerce;

import helpers.StringHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src\\resourcess\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcontactus");
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void registrationPageComplete(){
        RegistrationPage completeRegistrationPagee = new RegistrationPage(driver);
        String email = StringHelper.generateRandomEmail();
        completeRegistrationPagee.setGender("male");
        completeRegistrationPagee.fillInRegistrationForm("denis", "scaf",email,"Endava","123456","123456");
        completeRegistrationPagee.selectDayofBirth("23");
        completeRegistrationPagee.selectMonthofBirth("October");
        completeRegistrationPagee.selectYearofBirth("1996");
        completeRegistrationPagee.selectNewsletterCheckBox();
        completeRegistrationPagee.registerButton();

        assertEquals(completeRegistrationPagee.getresult(),"Your registration completed");

        completeRegistrationPagee.logOut();
        LoginPage log = completeRegistrationPagee.gotoLoginPage();
        log.completeLogInPage(email,"123456");
        assertThat(driver.getCurrentUrl(), is ("http://demo.nopcommerce.com/"));



    }
    @Test
    public void verifyLoginAfterSuccessfulRegistration(){
        RegistrationPage completeRegistrationPage = new RegistrationPage(driver);
        String email = StringHelper.generateRandomEmail();
        completeRegistrationPage.setGender("male");
        completeRegistrationPage.enterFirstName("Scafaru");
        completeRegistrationPage.enterLastName("Denis");
        completeRegistrationPage.enterEmail(email);
        completeRegistrationPage.enterCompanyInput("Endava");
        completeRegistrationPage.selectDayofBirth("3");
        completeRegistrationPage.selectYearofBirth("1996");
        completeRegistrationPage.selectMonthofBirth("October");
        completeRegistrationPage.enterpasswordInput("password");
        completeRegistrationPage.confirmpasswordInput("password");
        completeRegistrationPage.setGender("male");
        completeRegistrationPage.selectNewsletterCheckBox();
        completeRegistrationPage.registerButton();

       // assertEquals(completeRegistrationPage.getresult(), "Your registration completed");
        completeRegistrationPage.logOut();
        LoginPage log = completeRegistrationPage.gotoLoginPage();
        log.completeLogInPage(email,"password");
        assertThat(driver.getCurrentUrl(), is ("http://demo.nopcommerce.com/"));

    }
    @Test

    public void CheckValidShopping(){

        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        buildYourOwnComputer computer = homePage.gotobuildYourOwnComputer();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElements(computer.dropDownRam));

        computer.addRam("1");
        computer.HDD320.click();

        computer.clickToAdd();

    }



    //@AfterEach
    //public void tearDown(){
       // driver.quit();
    //}

}
