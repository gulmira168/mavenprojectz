package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicAuthentificationZeroBank {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(" http://zero.webappsecurity.com/login.html");

        WebElement inputUserName = driver.findElement(By.id("user_login"));
        inputUserName.sendKeys("username");

        WebElement inputPassword = driver.findElement(By.id("user_password"));
        inputPassword.sendKeys("password");

        WebElement signInButton = driver.findElement(By.name("submit"));
        signInButton.click();

        WebElement currentUsername = driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a"));
        String actualUserName = currentUsername.getText();
        String expectedUsername = "username";

        if(actualUserName.equals(expectedUsername)){
            System.out.println("Username verification PASSED");
        }else {
            System.out.println("Username verification FAILED");
        }


        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Zero - Account Summary";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        System.out.println(actualTitle);

    }
}
