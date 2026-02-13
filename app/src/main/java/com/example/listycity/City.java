package com.example.listycity;

import java.util.Objects;

/**
 * This class represents a City.
 * A city has a name and a province.
 */
public class City implements Comparable<City> {

    /** Name of the city */
    private String city;

    /** Name of the province */
    private String province;

    /**
     * Constructor for City
     * @param city Name of the city
     * @param province Name of the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the city name
     * @return city name
     */
    public String getCityName(){
        return this.city;
    }

    /**
     * Returns the province name
     * @return province name
     */
    public String getProvinceName(){
        return this.province;
    }

    /**
     * Compares cities alphabetically by name
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Checks if two cities are equal.
     * Cities are equal if both city and province match.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    /**
     * Generates hashCode consistent with equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
