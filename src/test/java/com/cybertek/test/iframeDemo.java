package com.cybertek.test;

/*1. create a new class IframeDemo
2. go to url https://the-internet.herokuapp.com/tinymce
3. enter text in the text editor

*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeDemo {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");

        // locate the iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        // switch to iframe
        driver.switchTo().frame(iframe);


        driver.findElement(By.tagName("body")).
                sendKeys("ddeee dddedd  dd");


        // switches html pages inside of the HTML page
        // f.e. if you have 2 html pages inside of one html page,
        // so to find something outside of inner html page we have to use this command.
        // this command takes to the parent of the current frame.
        driver.switchTo().parentFrame();

        //find Elemental Selenium which is outside of the inner html page:
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //if you have several html pages inside of one HTML parent page,
        // use this command to get to the top parent HTML page content.
        // this command takes you back directly to the top html page,
                        //driver.switchTo().defaultContent();





    }
}
