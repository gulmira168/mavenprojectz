package com.cybertek.chicagoSmartbearSoftware;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartbearSoftwareLoginTCPositive {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx/");


        String loginTitle = driver.getTitle();
        if(loginTitle.equals("Web Orders Login")){
            System.out.println("Login title verification Passed");
        }else {
            System.out.println("Login title verification Failed");
        }
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        userName.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();



        String newTitle = driver.getTitle();
        if(newTitle.equals("Web Orders")){
            System.out.println("New title verification Passed");
        }else {
            System.out.println("New title verification Failed");
        }



        String url = driver.getCurrentUrl();
        if(url.equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")){
            System.out.println("URL verification Passed");
        }else {
            System.out.println("URL verification Failed");
        }


        driver.findElement(By.linkText("Order")).click();
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productDropdown = new Select(product);
        Thread.sleep(1500);
        productDropdown.selectByIndex(2);
        //productDropdown.selectByValue("FamilyAlbum");
        //productDropdown.selectByVisibleText();


    }
}
