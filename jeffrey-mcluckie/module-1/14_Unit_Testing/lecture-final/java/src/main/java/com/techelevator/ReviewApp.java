package com.techelevator;

public class ReviewApp {
    public static void main(String[] args) {
        // Create a person object - using default constructor
        // This Person has no email - we said email is required
        // Better not to allow us to create the person without it!
        // Add a constructor that sets the email.
        // Person person = new Person(); // No more default constructor
        Person person = new Person("someone@somewhere.com");
        System.out.println("Created a person... " + person);

        // Make an employee
        Employee employee = new Employee(null, "some@some.com");
        System.out.println("Created an employee... " + employee);
    }
}
