package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CraiglistTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().fullscreen();


        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("https://washingtondc.craigslist.org/");

        //driver.findElement(By.name("query")).sendKeys("corolla");
        //driver.findElement(By.linkText("electronics")).click(); // it has to match fully to the text even with spaces otherwise search fails
        driver.findElement(By.partialLinkText("+garden")).click(); // it has to match fully to the some part of the text




    }
}

