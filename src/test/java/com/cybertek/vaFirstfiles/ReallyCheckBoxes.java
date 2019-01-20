package com.cybertek.vaFirstfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/*
go to ==>http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
verify Monday is not selected
select Monday
verify Monday is selected
unselect Monday
 */
public class ReallyCheckBoxes {
    public static void main(String[] args) {

         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();


         driver.manage().window().fullscreen();
         //Thread.sleep(1000); // stops everything
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // works only when findElement method is active


         driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
         WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));


//            System.out.println(monday.isSelected()); // false ---> boolean return type method called isSelected belongs to the 'WebElement class',
//                    monday.click();
//            System.out.println(monday.isSelected()); // true  ---> because we clicked on button
//                    monday.click(); //reversed the previous action
//            System.out.println(monday.isSelected()); // false ---> because we unclicked the button


                    System.out.println(monday.isSelected());
                    if (!monday.isSelected()) {
                        monday.click();
                    }
                    System.out.println(monday.isSelected());

    }
}