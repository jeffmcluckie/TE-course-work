package com.techelevator;

import java.util.Collections;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private String start;
    private String dueDate;
    private List<Employee> teamMembers = Collections.<Employee>emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Project(String name, String description, String start, String dueDate) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.dueDate = dueDate;
    }
}
