package com.techelevator.dao;

import com.techelevator.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public List<Person> getAllPeople() {
        List<Person> personList = new ArrayList<Person>();
        String sql = "SELECT * FROM person ORDER BY last_name, first_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            personList.add( mapRowToPerson(results) );
        }
        return personList;
    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }

    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setFirstName(rowSet.getString("first_name"));
        person.setLastName(rowSet.getString("last_name"));
        return person;
    }
}
