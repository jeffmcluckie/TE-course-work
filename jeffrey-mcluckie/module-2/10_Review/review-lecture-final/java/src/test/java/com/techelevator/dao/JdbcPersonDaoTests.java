package com.techelevator.dao;

import com.techelevator.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcPersonDaoTests extends BaseDaoTests {

    private PersonDao dao;

    @Before
    public void setup() {
        dao = new JdbcPersonDao(dataSource);
    }

    @Test
    public void getAllPeople_returns_all_people(){
        List<Person> people = dao.getAllPeople();
        Assert.assertEquals(3, people.size());
    }



}
