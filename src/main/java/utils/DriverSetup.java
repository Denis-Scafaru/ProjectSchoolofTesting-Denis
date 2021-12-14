package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    public static WebDriver driver;

    public static ChromeDriver driverInit (){
        System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }
    public static void setDriver(){
        driver= driverInit();
        driver.manage().window().maximize();
    }
}
