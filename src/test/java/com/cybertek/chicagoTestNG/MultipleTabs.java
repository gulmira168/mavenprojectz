package com.cybertek.chicagoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipleTabs {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void googleTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());  // it's a kind of ID of the window like this ==> CDwindow-7407DDC4C9AEDC39972C19177BB18613
        System.out.println(driver.getTitle());

        String mainHandle = driver.getWindowHandle();
        //driver.findElement(By.linkText("Elemental Selenium")).click();
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getTitle());  // Selenium still pointing the title of the other window. So how can we solve this issue?


// through the loop we have to get the IDs of all windows and then we can switch to the target window we want to work on it:
        List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
        for(String s : allHandles){
            if(!s.equals(mainHandle)){
                driver.switchTo().window(s);
                break;
            }
        }

// we are getting the target window we want to work on it:
        //driver.switchTo().window(allHandles.get(1));

        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.close();  // we can close a window we don't need anymore
        driver.switchTo().window(mainHandle);
        System.out.println(driver.getTitle());

    }
}

/*
Interview question:
How can we handle a multiple tabs in selenium?
Every window has a unique ID. With the help of window handles we can switch to the a target window.

 */