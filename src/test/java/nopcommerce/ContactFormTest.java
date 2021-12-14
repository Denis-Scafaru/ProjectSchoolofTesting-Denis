package nopcommerce;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactFormTest
{
        WebDriver driver;

        @BeforeEach
        public void setUp (){
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("https://demo.nopcommerce.com/contactus");
        }


        @Test
        public void contactFormComplete (){
                ContactForm newcontact = new ContactForm(driver);
                newcontact.enterfullname("Denis");
                newcontact.addenquiry("Text nonsense");
                newcontact.addemail("Denis@gmail.com");
                newcontact.SubmitButton();
                assertEquals(newcontact.getResult(),"Your enquiry has been successfully sent to the store owner.");
        }

        @Test
        public void contactFormError (){
                ContactForm contactForm = new ContactForm(driver);
                contactForm.fillInContactForm("", "", "");
                assertThat(contactForm.getfullnameErrorMessage(), is("Enter your name"));
                assertThat(contactForm.getEnquiryErrorMessage(), is ("Enter enquiry"));
                assertThat(contactForm.getEmailErrorMessage(), is("Enter email"));
        }

        @Test

        public void checkinvalidemailformat (){
                ContactForm submitPage = new ContactForm(driver);
                submitPage.fillInContactForm("da" , "plm" , "daaa" );
                assertEquals(submitPage.getEmailErrorMessage(), "Wrong email");



        }

        @AfterEach
        public void tearDown(){
                driver.quit();
        }


}

