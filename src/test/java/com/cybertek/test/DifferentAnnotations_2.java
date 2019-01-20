package com.cybertek.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations_2 {



    @Test
    public void testOne(){
        System.out.println("This is test 1");
    }



    @Test
    public void testTwo(){
        System.out.println("This is test 2");
    }



    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }



    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
    }



}
