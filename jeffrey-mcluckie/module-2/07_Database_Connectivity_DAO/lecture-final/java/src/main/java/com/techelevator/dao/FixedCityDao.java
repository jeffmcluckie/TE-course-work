package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.ArrayList;
import java.util.List;

public class FixedCityDao implements CityDao {

    private List<City> internalList = new ArrayList<>();

    @Override
    public City getCity(long cityId) {
        // Loop through the internal list, if id matches return it
        return null;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return internalList;
    }

    @Override
    public City createCity(City city) {
        internalList.add(city);
        city.setCityId(1); // probably needs to have a unique id
        return city;
    }

    @Override
    public void updateCity(City city) {
        // Loop through the internal list, if id matches return update it
    }

    @Override
    public void deleteCity(long cityId) {
        // Loop through the internal list, if id matches return update it
    }
}
