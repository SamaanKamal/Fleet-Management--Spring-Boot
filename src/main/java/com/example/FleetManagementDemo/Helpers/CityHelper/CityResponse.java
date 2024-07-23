package com.example.FleetManagementDemo.Helpers.CityHelper;

import com.example.FleetManagementDemo.Entity.City;

import java.util.List;

public class CityResponse {
    List<City> cities;

    public CityResponse(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }
}
