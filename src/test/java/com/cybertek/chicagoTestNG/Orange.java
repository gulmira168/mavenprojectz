package com.cybertek.chicagoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Orange {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @BeforeMethod
    public void testSetup(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().fullscreen();
    }


    @AfterMethod
    public void testCleanup(){
        //driver.close();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void orangeTitleVerification(){
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Orange HRM Title verification");

    }


    @Test
    public void orangeLoginVerification(){
        System.out.println(driver.getPageSource());
        Assert.fail("On purpose failure");
    }
}
