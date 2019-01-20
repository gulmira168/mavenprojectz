package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VerifyCheckboxFunctionality {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(" http://the-internet.herokuapp.com/checkboxes");


//        <form id="checkboxes">
//    <input type="checkbox"> checkbox 1<br>
//    <input type="checkbox" checked=""> checkbox 2
//                </form>

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));


        if (!checkbox1.isSelected()) {
            System.out.println("Checkbox 1: PASSED");
        } else {
            System.out.println("Checkbox 1: FAILED");
        }


        if (checkbox2.isSelected()) {
            System.out.println("Checkbox 2: PASSED");
        } else {
            System.out.println("Checkbox 2: FAILED");
        }

        System.out.println("Clicking Checkbox 1");

        checkbox1.click();
        if (checkbox1.isSelected()) {
            System.out.println("Checkbox 1: PASSED");
        } else {
            System.out.println("Checkbox 1: FAILED");
        }


    }

    }

