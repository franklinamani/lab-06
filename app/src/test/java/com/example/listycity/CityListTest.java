package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City duplicate = mockCity();

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(duplicate);
        });
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));

        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        cityList.delete(city);
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "BC");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(2, cityList.countCities());
    }

    @Test
    void testGetCitiesSorted() {
        CityList cityList = new CityList();
        cityList.add(new City("Toronto", "Ontario"));
        cityList.add(new City("Calgary", "Alberta"));

        assertEquals("Calgary", cityList.getCities().get(0).getCityName());
        assertEquals("Toronto", cityList.getCities().get(1).getCityName());
    }
}

