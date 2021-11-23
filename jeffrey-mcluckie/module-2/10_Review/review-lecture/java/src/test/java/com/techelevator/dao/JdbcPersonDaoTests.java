package com.techelevator.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoTests extends BaseDaoTests {

    private PersonDao dao;

    @Before
    public void setup() {
        dao = new JdbcPersonDao(dataSource);
    }



}
