package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Openxcell {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://openxcell.com");
        System.out.println(driver.getTitle());

        WebElement caseStudies = driver.findElement(By.linkText("Case Studies"));
        System.out.println(caseStudies.getAttribute("class"));
        System.out.println(caseStudies.getAttribute("href"));
        System.out.println(caseStudies.getText());
    }
}
