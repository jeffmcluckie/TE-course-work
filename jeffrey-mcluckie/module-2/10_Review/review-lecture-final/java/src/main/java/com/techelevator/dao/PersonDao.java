package com.techelevator.dao;

import com.techelevator.model.Person;

import java.util.List;

public interface PersonDao {

    Person getPerson(long id);

    List<Person> getAllPeople();

    Person createPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(long id);
}
