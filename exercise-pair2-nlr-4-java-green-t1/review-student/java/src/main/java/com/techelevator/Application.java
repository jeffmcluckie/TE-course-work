package com.techelevator;

import java.util.*;

public class Application {
    private List<Department> departments = new ArrayList<Department>();
    private List<Employee> employees = new ArrayList<Employee>();
    private Map<String,Project> projects  = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();
            departments.add(0, new Department(1, "Marketing"));
            departments.add(1, new Department(2, "Sales"));
            departments.add(2, new Department(3, "Engineering"));


        // print each department by name
        printDepartments();
        for(Department departmentElement : departments){
            System.out.println(departmentElement.getName());
        }

        // create employees
        createEmployees();
            Employee deanJohnson = new Employee();
            deanJohnson.setEmployeeId(1);
            deanJohnson.setFirstName("Dean");
            deanJohnson.setLastName("Johnson");
            deanJohnson.setEmail("djohnson@teams.com");
            deanJohnson.setSalary(60000);
            deanJohnson.setDepartment(departments.get(2));
            deanJohnson.setHireDate("08/21/2020");

            Employee angieSmith = new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
            angieSmith.setSalary(66000);

            Employee margaretThompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");
            margaretThompson.setSalary(60000);

            employees.add(0, deanJohnson);
            employees.add(1, angieSmith);
            employees.add(2, margaretThompson);

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();
        printDepartments();
        for(Employee employeeElement : employees){
            System.out.println(employeeElement.getFullName() + " (" + employeeElement.getSalary() + ") " + employeeElement.getDepartment().getName());
        }

        // create the TEams project
        createTeamsProject();
        Project teams = new Project("TEams","Project Management Software", "10/10/2020", "11/10/2020");
        employees.remove(2);
        teams.setTeamMembers(employees);
       projects.put("First",teams);

        // create the Marketing Landing Page Project
        createLandingPageProject();
        Project teams2 = new Project("Marketing Landing Page","Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
        employees.add(2,margaretThompson);
        employees.remove(0);
        employees.remove(1);
        teams2.setTeamMembers(employees);
        projects.put("Second", teams2);


        // print each project name and the total number of employees on the project
        printProjectsReport();
        System.out.println(projects.get("First").getName() + ": 2");
        System.out.println(projects.get("Second").getName() + ": 1");



    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");

    }

}
