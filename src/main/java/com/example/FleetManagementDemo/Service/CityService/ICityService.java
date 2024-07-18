package com.example.FleetManagementDemo.Service.CityService;


import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Helpers.CityHelper.CityRequest;

import java.util.List;

public interface ICityService {
    List<City> getAllCities();

    City getCityById(Long id);

    City addNewCity(CityRequest cityRequest);

    City updateCity(CityRequest cityRequest,Long id);

    boolean deleteCity(Long id);
}
