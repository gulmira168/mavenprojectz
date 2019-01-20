package com.cybertek.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedUpDependencies {


    @Test(priority = 3)
    public void openBrowser(){

        System.out.println("Opening a browser");
    }


    @Test(dependsOnMethods = "openBrowser")
    public void login(){
        System.out.println("Login");
       // Assert.assertTrue(false);
    }


    @AfterMethod
    public void cleanUp(){

        System.out.println("Close the browser");
    }
}
