package com.cybertek.vaFirstfiles;

import com.github.javafaker.Faker;

public class Anything {
    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println(faker.dog().breed());
        System.out.println(faker.address());
        System.out.println(faker.ancient());
    }
}
