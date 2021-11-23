package com.techelevator;

public class FruitsBasketApp {
    public static void main(String[] args) {
        // calls our default constructor (there isn't one in the class)
        Person kyo = new Person();
        kyo.setName("Kyo");
        kyo.setGender("male");
        kyo.setZodiacMember(true);
        System.out.println("Created a person: " + kyo);

        Person yuki = new Person("Yuki", "male");
        yuki.setZodiacMember(true);
        System.out.println("Created a person: " + yuki);

        Person tohru = new Person("Tohru", "female");
        System.out.println("Created a person: " + tohru);

        // More people
        Person uotani = new Person("Uotani", "female");
        Person kazuma = new Person("Kazuma", "male");

        yuki.hug(tohru);
        kyo.hug(yuki);
        uotani.hug(tohru);
        kazuma.hug(kyo);

        // Equals exists on every object, part of what it means
        // in Java to be an object
        String hello = "hello";
        String goodbye = "good-bye";
        if (hello.equals(goodbye)){
            System.out.println("Really??!");
        }

        // Accessing MY_CONSTANT from the class because it is static
        System.out.println(Person.MY_CONSTANT);

        // Cannot change the value of a final variable - a constant
        // Person.MY_CONSTANT = "Hello";

        if(yuki.equals(kyo)){
            System.out.println("same person");
        } else {
            System.out.println("different people");
        }
    }
}
