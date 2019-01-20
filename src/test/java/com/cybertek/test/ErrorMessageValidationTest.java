package com.cybertek.test;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.ListingPage;
import com.cybertek.pages.PrestaShopHomePage;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ErrorMessageValidationTest extends TestBase {
    HomePage homePage = new HomePage();


    @Test
    public void wrongEmailTest() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        homePage.username.sendKeys("admin");
        //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("wrongEmail");


        homePage.password.sendKeys("test");
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");


        homePage.loginButton.click();
        //driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        String actualError = homePage.errorMessage.getText();
        //String actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();


        String expectedError = "Invalid Login or Password.";

        Assert.assertEquals(actualError, expectedError);
    }


    @Test
    public void wrongPasswordTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("wrongPassword");
        homePage.loginButton.click();

        String actualError = homePage.errorMessage.getText();
        String expectedError = "Invalid Login or Password.";

        Assert.assertEquals(actualError, expectedError);
    }


    @Test
    public void blankUsernameTest(){
        homePage.open();
        homePage.login("", "test"); //instead of below 3 lines we called just a method with 2 args
        String actualError = homePage.errorMessage.getText();
        String expectedError = "Invalid Login or Password.";
        Assert.assertEquals(actualError, expectedError);
    }


    @Test
    public void blankPasswordTest(){
        homePage.open();
        homePage.login("Tester", "");
        String actualError = homePage.errorMessage.getText();
        String expectedError = "Invalid Login or Password.";
        Assert.assertEquals(actualError, expectedError);
    }


    @Test
    public void blankEmailAndPassword(){
        homePage.open();
        homePage.login("", "");
        String actualError = homePage.errorMessage.getText();
        String expectedError = "Invalid Login or Password.";
        Assert.assertEquals(actualError, expectedError);
    }


    //this is just a method which doesn't do anything
    @Test
    public void test(){
        ListingPage nilesLane = new ListingPage();
        ListingPage palmetLane = new ListingPage();
        PrestaShopHomePage prestaShopHomePage = new PrestaShopHomePage();
        WebElement tShirt = prestaShopHomePage.product("tshirt");
        WebElement dress = prestaShopHomePage.product("dress");


    }

}
