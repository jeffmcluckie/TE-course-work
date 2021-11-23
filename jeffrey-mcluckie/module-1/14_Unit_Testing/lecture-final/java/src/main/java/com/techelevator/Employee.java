package com.techelevator;

public class Employee extends Person {

    // All employees MUST have an employeeNumber
    private String employeeNumber;

    // Probably not a good idea, but this would create employees with a blank email
    public Employee() {
        super("");
    }

    // Parent class requires email, so we get it when we create an employee
    // If employeeNumber is required, should probably take this in too...
    public Employee(String email) {
        super(email);
    }

    // Get both required properties together
    public Employee(String employeeNumber, String email) {
        super(email); // parent part is happy
        this.employeeNumber = employeeNumber; // child part is happy
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}
