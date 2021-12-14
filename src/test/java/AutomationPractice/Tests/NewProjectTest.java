package AutomationPractice.Tests;

import AutomationPractice.CreateAnAccount;
import AutomationPractice.HomePageAutomation;
import AutomationPractice.SignInPage;
import helpers.StringHelper;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class NewProjectTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src\\resourcess\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test

    public void VerifyMailError(){
        driver.manage().window().maximize();
        HomePageAutomation homePage = new HomePageAutomation(driver);
        SignInPage createAccount = homePage.goToSignInPage();

        new WebDriverWait(driver, 10).until(elementToBeClickable(By.id("email_create")));
        createAccount.emailinput.sendKeys("calutu");
        createAccount.submitButton.click();
        new WebDriverWait(driver, 20).until(visibilityOf(createAccount.emailError));
        assertThat(createAccount.emailError.getText(), is ("Invalid email address."));

    }
    @Test
    public void signInContactNoFields(){
        driver.manage().window().maximize();
        HomePageAutomation homePage = new HomePageAutomation(driver);
        String email = StringHelper.generateRandomEmail();
        SignInPage createAccount = homePage.goToSignInPage();
        createAccount.enterEmail(email);
        CreateAnAccount completeAccountFields = createAccount.redirectPage();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));
        //completeAccountFields.setSelectCountry("-");

        completeAccountFields.submitAccountButton.click();
        assertThat(completeAccountFields.getResultError(), is ("There are 8 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
                "This country requires you to choose a State."));

    }

    @Test
    public void CheckPostCodeState(){
        driver.manage().window().maximize();
        HomePageAutomation homePage = new HomePageAutomation(driver);
        String email = StringHelper.generateRandomEmail();
        SignInPage createAccount = homePage.goToSignInPage();
        createAccount.enterEmail(email);
        CreateAnAccount completeAccountFields = createAccount.redirectPage();

        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInRegistrationForm("Denis", "Scafaru","1234567", "Endava","Sf Ap Petru si Pavel, 320, 230","Sf Ap Petru si Pavel, 320, 230", "Timisoara", "90264","none","02562221372","0730235828","Sf Ap Petru si Pavel");
        completeAccountFields.selectDayOfBirth("23");
        completeAccountFields.selectMonthOfBirth("10");
        completeAccountFields.selectYearOfBirth("2000");
        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        completeAccountFields.setSelectCountry("-");
        completeAccountFields.submitAccountButton.click();
        assertTrue(completeAccountFields.postalCodeInput.isDisplayed());
//        assertFalse(completeAccountFields.postalCodeInput.isDisplayed());
//        assertFalse(completeAccountFields.americaStateDropDown.isDisplayed());


    }
    @Test
    public void signInContactValid(){
        driver.manage().window().maximize();
        HomePageAutomation homePage = new HomePageAutomation(driver);
        String email = StringHelper.generateRandomEmail();

        SignInPage createAccount = homePage.goToSignInPage();
        createAccount.enterEmail(email);
        CreateAnAccount completeAccountFields = createAccount.redirectPage();

        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInRegistrationForm("Denis", "Scafaru","1234567", "Endava","Sf Ap Petru si Pavel, 320, 230","Sf Ap Petru si Pavel, 320, 230", "Timisoara", "90264","none","02562221372","0730235828","Sf Ap Petru si Pavel");
        completeAccountFields.selectDayOfBirth("23");
        completeAccountFields.selectMonthOfBirth("10");
        completeAccountFields.selectYearOfBirth("1996");
        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        //completeAccountFields.setSelectCountry("United States");
        completeAccountFields.submitAccountButton.click();
        assertThat(driver.getCurrentUrl(), is("http://automationpractice.com/index.php?controller=my-account"));
    }
    @Test
    public void signInContact18Year(){
        driver.manage().window().maximize();
        HomePageAutomation homePage = new HomePageAutomation(driver);
        String email = StringHelper.generateRandomEmail();

        SignInPage createAccount = homePage.goToSignInPage();
        createAccount.enterEmail(email);
        CreateAnAccount completeAccountFields = createAccount.redirectPage();

        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInRegistrationForm("Denis", "Scafaru","1234567", "Endava","Sf Ap Petru si Pavel, 320, 230","Sf Ap Petru si Pavel, 320, 230", "Timisoara", "90264","none","02562221372","0730235828","Sf Ap Petru si Pavel");
        completeAccountFields.selectDayOfBirth("23");
        completeAccountFields.selectMonthOfBirth("10");
        completeAccountFields.selectYearOfBirth("2008");

        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        completeAccountFields.submitAccountButton.click();
        assertThat(driver.getCurrentUrl(), is("http://automationpractice.com/index.php?controller=my-account"));

    }

    @AfterEach

    public void tearDown(){
        driver.quit();
    }



}
