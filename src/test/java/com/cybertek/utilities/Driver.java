package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;


    //We called private constrictor, so that no one could make an object of this class.
    // Whoever needs to use driver object has to call a getDriver() method.
    private  Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
