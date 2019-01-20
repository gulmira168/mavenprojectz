package com.cybertek.vaFirstfiles;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
go to https://
 */

public class CheckBoxes {

    public static void main(String[] args) {

// setting driver path for chrome using the webdrivermanager:
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));

        // Way 1
        // input.sendKeys("somemeai@somemail.com" + Keys.ENTER);

        // Way 2
        input.sendKeys("somemeai@somemail.com");
        input.submit();

        String expected = "Your e-mail's been sent!";

        String actual =
                driver.findElement(By.id("content")).getText();

                if(actual.equals(expected)){
                    System.out.println("PASS");
                }else {
                    System.out.println("FAIL");
                    System.out.println("actual = " + actual);
                    System.out.println("expected = " + expected);
                }


    }
}
