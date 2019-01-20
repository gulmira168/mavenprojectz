package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClickOnLinks {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");
        WebElement fileDownload = driver.findElement(By.linkText("File Download"));
        fileDownload.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verificaiton PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }
        System.out.println(actualTitle);

        driver.navigate().back();

        WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
        fileUpload.click();

        String actualUpLoadTitle = driver.getTitle();
        String expectedUploadTitle = "The Internet";
        if(actualUpLoadTitle.equals(expectedUploadTitle)){
            System.out.println("Title verificaiton PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        System.out.println(actualUpLoadTitle);



    }
}
