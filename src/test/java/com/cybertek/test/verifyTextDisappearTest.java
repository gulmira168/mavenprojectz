package com.cybertek.test;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTextDisappearTest extends TestBase {

    @Test
    public void verify1() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement text = driver.findElement(By.id("myDIV"));
        Assert.assertTrue(text.isDisplayed());
        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();
        Assert.assertFalse(text.isDisplayed());
        //Assert.assertTrue(!text.isDisplayed());
        System.out.println(text.isDisplayed());
    }


    @Test
    public void verify2() {
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");
        driver.switchTo().frame("iframeResult");
        WebElement text = driver.findElement(By.xpath("//body/p"));
        System.out.println(text.getText());
        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        Assert.assertTrue(elementDisplayed(By.xpath("//body/p")));

//        try {
//            Assert.assertFalse(text.isDisplayed());
//        }catch (StaleElementReferenceException e){
//            Assert.assertTrue(true);
//        }
    }

    /**
     * takes a locator and returns if element matching this locator exists
     * @param by
     * @return
     */

    public boolean elementDisplayed(By by) {
        // try find it
        // if can't find it, return false

        try{
            driver.findElement(by).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


    public boolean elementDisplayedS(By by){
        //if the locator matches the list won't be empty,
        //if the locator does not match anything the list will be empty.
        return driver.findElements(by).isEmpty();
    }
}





