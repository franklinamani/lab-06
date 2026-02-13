package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class keeps track of a list of City objects.
 */
public class CityList {

    /** List storing city objects */
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     * @param city candidate city to add
     * @throws IllegalArgumentException if city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists.");
        }
        cities.add(city);
    }

    /**
     * Returns whether a given city exists in the list.
     * @param city city to search
     * @return true if city exists, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     * @param city city to remove
     * @throws IllegalArgumentException if city does not exist
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found.");
        }
        cities.remove(city);
    }

    /**
     * Returns number of cities in the list.
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a sorted list of cities.
     * @return sorted list of cities
     */
    public List<City> getCities() {
        List<City> sortedList = new ArrayList<>(cities);
        Collections.sort(sortedList);
        return sortedList;
    }
}
