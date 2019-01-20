package com.cybertek.chicagoSmartbearSoftware;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearPlacedOrder {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx/");
        SmartbearOrder.loginToSmartbear(driver);


        WebElement susanDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));


        if(susanDate.getText().equals("01/05/2010")){
            System.out.println("Susan McLaren order verification is PASSED");
        }else {
            System.out.println("Susan McLaren order verification is FAILED");
        }


        //Calling a method:
        verifyOrder(driver,"Susan McLaren");

    }

        //Defining a method:
        public static void verifyOrder(WebDriver driver, String orderName){
            List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
            for(WebElement name : names){
                //System.out.println(name); // prints all name references
                System.out.println(name.getText()); // prints out all names inside the column of name
                if(name.getText().equals(orderName)){
                    System.out.println("Order name verification PASSED");
                    return;
                }
            }
            System.out.println("Order name verification FAILED");



          //Defining a method:
          // this method should simply print all the names in the list of all order.

//        public static void allNames(WebDriver driver){
//                List<WebElement> names1 = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
//                for(WebElement name1 : names1){
//                   System.out.println(name1.getText()); // prints out all names in the table
//                   System.out.println(name1); // prints out references of all names in the table

//                }
//            }

    }
}
