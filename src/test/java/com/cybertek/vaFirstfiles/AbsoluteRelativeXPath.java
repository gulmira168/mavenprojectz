package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AbsoluteRelativeXPath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        WebElement framesButton = driver.findElement(By.linkText("Frames"));
        framesButton.click();

        driver.findElement(By.xpath("//a[.='iFrame']")).click();
        //driver.findElement(By.xpath("//h3[.='Frames']")).click();
    }
}
