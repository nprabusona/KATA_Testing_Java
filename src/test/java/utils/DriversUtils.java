package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class DriversUtils {
    static WebDriver driver;
    static Actions action;
    
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
    }

    public static WebDriver getDriver() {

        if (driver == null ) {
            initDriver();
        }
        return driver;
    }

    public static Actions getAction() {
    	
    	action = new Actions(driver);
    	return action; 		
    }
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}

