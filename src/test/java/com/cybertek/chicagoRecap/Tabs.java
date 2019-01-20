package com.cybertek.chicagoRecap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tabs {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void startTest() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void multipleTabs() {
        driver.get("https://amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.google.com' , '_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.etsy.com' , '_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.openxcell.com' , '_blank');");

        System.out.println(driver.getCurrentUrl()); // got the current URL;
        System.out.println(driver.getTitle()); // got the current title;

        //but we want get to another tab => etsy.com:
        String targetTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }
}