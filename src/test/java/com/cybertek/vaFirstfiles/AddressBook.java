package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddressBook {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://a.testaddressbook.com/");
        WebElement signIn = driver.findElement(By.xpath("//a[@id='sign-in']"));
        signIn.click();
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='container']/div[1]"));
        String message = errorMessage.getText();
        System.out.println(message);
        if(message.equals("Bad email or password.")){
            System.out.println("Error message verification is PASSED");
        }else {
            System.out.println("Error message verification is FAILED");
        }
        System.out.println(errorMessage.isDisplayed());
    }
}
