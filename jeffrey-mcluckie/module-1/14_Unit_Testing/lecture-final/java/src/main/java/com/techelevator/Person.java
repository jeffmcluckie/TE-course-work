package com.techelevator;

public class Person {
    // Names are optional
    private String firstName;
    private String lastName;

    // Everyone must give an email
    private String email;

    // Required, but maybe not something to pass around. We'll leave for now
    private String password;

    // Want to require email, so make sure it is set in the constructor
    public Person(String email) {
        this.email = email;
    }

    // Want to make a 1 step way to make a person with req email & optional name properties
    // Overloading the constructor
    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // This would be the default constructor
    // BUT having this means we could have a person with no email!!!
    //public Person() {}


    // Generally makes sense to have getter for most (if not all) properties
    // BUT not always. Think about your app & situation
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // If a property can be changed, provide a setter.
    // If it does not make sense to change or MUST never change - don't.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
