package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
    public class buildYourOwnComputer {
        @FindBy(id = "product_attribute_2")
        public WebElement dropDownRam;
        @FindBy(id = "add-to-cart-button-1")
        private WebElement buttonAdd;
        @FindBy(id = "product_attribute_3_6")
        public WebElement HDD320;
        @FindBy(id = "product_attribute_3_7")
        public WebElement HDD400;


        protected WebDriver driver;
        protected WebDriverWait wait;

        public buildYourOwnComputer(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }


        public void addRam(String addValue){
            Select drop = new Select(dropDownRam);
            drop.selectByIndex(1);
        }

        public void clickToAdd(){
            buttonAdd.click();
        }
    }





