package com.cybertek.utilities;

public class Example {
    public static void main(String[] args) {

        String one = Singleton.get();
        System.out.println("one: " + one);

        String two = Singleton.get();
        System.out.println("two: " + two);

        String tree = Singleton.get();
        System.out.println("three: " + tree);

    }

}

//        Wrong email
//        1. go to website http://automationpractice.com/index.php
//        2. try to login with wrong email
//        3. verify error message Invalid email address.
//        Wrong password
//        1. go to website http://automationpractice.com/index.php
//        2. try to login with wrong password
//        3. verify error message Authentication failed.
//        No email
//        1. go to website http://automationpractice.com/index.php
//        2. try to login with wrong password
//        3. verify error message An email address required.
//        No password
//
//        1. go to website http://automationpractice.com/index.php
//        2. try to login with wrong password
//        3. verify error message Password is required.
