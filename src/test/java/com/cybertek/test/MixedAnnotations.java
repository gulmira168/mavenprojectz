package com.cybertek.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MixedAnnotations {


    WebDriver driver;



    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up the drivers here");
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setUpTMethods(){
        System.out.println("Opening a browser");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Go to a website and login");
        driver.get("https://gogole.com");
    }


    @Test
    public void testOne(){
        System.out.println("Testing the first test");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("Logout");
        System.out.println("Closing browser");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("Report everything");
    }

    @Test
    public void testTow(){
        System.out.println("Testing the second test");
    }
}
