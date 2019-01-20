package com.cybertek.chicagoSmartbearSoftware;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartbearSoftwareLoginTCNegative {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

// Calling a method = negativeLogin
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx/");
        negativeLogin(driver, "Tester", "");
        negativeLogin(driver, "Test", "");
        negativeLogin(driver, "", "test");
        negativeLogin(driver, "James Bond", "test");


//        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
//        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
//        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
//        userName.sendKeys("Tester");
//        password.sendKeys(" ");
//        loginBtn.click();
//
//
//        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
//        if(errorMessage.getText().equals("Invalid Login or Password.")){
//            System.out.println("Error message verification passed");
//        }else {
//            System.out.println("Error message verification failed");
//        }
    }


//Defining a method = negativeLogin:
    public static void negativeLogin(WebDriver driver, String usernameValue, String passwordValue){
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));

        userName.clear();
        userName.sendKeys(usernameValue);
        password.clear();
        password.sendKeys(passwordValue);
        loginBtn.click();


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
        if(errorMessage.getText().equals("Invalid Login or Password.")){
            System.out.println("Error message verification passed");
        }else {
            System.out.println("Error message verification failed");
        }



    }
}
