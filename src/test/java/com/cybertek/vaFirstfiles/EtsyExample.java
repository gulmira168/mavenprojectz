package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EtsyExample {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://etsy.com");

        WebElement input = driver.findElement(By.id("search-query"));
        input.sendKeys("decal");
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submit.click();

    }
}
