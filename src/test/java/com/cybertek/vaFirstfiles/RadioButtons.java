package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        // verify blue and red not checked
        WebElement blue=driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red=driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));
            System.out.println("BY DEFAULT:");
            System.out.println("blue button: " + blue.isSelected());
            System.out.println("red button: " + red.isSelected());

            //check blue
            System.out.println("Clicking on blue button");
                blue.click();

            //verify blue checked, red not checked
            System.out.println("blue button: " + blue.isSelected());
            System.out.println("red button: " + red.isSelected());

            //check red
            System.out.println("Clicking on red button:");
                red.click();

            //verify blue not checked, red is checked
            System.out.println("blue button: " + blue.isSelected());
            System.out.println("red button: " + red.isSelected());

    }
}
