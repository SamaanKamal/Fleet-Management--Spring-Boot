package com.example.FleetManagementDemo.Service.CityService;

import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Helpers.CityHelper.CityRequest;
import com.example.FleetManagementDemo.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City not found with id:"  + id));
    }

    @Override
    public City addNewCity(CityRequest cityRequest) {
        City city=new City();
        city.setName(cityRequest.getName());
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(CityRequest cityRequest, Long id) {
        City city =cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City not found with id:"  + id));
        city.setName(cityRequest.getName());
        cityRepository.save(city);
        return city;
    }

    @Override
    public boolean deleteCity(Long id) {
        City deletedCity =cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City not found with id:"  + id));
        if(deletedCity!=null){
            cityRepository.delete(deletedCity);
            return true;
        }
        return false;
    }
    public City findByName(String name) {
        Optional<City> city = cityRepository.findByName(name);
        return city.get();
    }
}
