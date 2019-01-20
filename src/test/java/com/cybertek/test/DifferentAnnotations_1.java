package com.cybertek.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





public class DifferentAnnotations_1 {



    @Test
    public void testOne(){
        System.out.println("This is test 1");
    }



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }



    @Test
    public void testTwo(){
        System.out.println("This is test 2");
    }
}
