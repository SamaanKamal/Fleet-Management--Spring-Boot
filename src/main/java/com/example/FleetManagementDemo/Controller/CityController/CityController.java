package com.example.FleetManagementDemo.Controller.CityController;

import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Helpers.CityHelper.CityRequest;
import com.example.FleetManagementDemo.Helpers.CityHelper.CityResponse;
import com.example.FleetManagementDemo.Service.CityService.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cities")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<CityResponse> fetchAllCities(){
        List<City> cities = cityService.getAllCities();
        if(cities==null){
            return ResponseEntity.notFound().build();
        }
        CityResponse cityResponse = new CityResponse(cities);
        return ResponseEntity.ok(cityResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<City> fetchCity(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        City city = cityService.getCityById(id);
        if(city ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody CityRequest cityRequest){
        if(cityRequest==null){
            return ResponseEntity.badRequest().build();
        }
        City city = cityService.addNewCity(cityRequest);
        if(city!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(city);
        }
        return  ResponseEntity.internalServerError().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id,@RequestBody CityRequest cityRequest){
        if(cityRequest==null||id ==null){
            return ResponseEntity.badRequest().build();
        }
        City city = cityService.updateCity(cityRequest,id);
        if(city!=null){
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
        return  ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id){
        if(id ==null){
            return ResponseEntity.badRequest().build();
        }
        boolean isDeleted= cityService.deleteCity(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("City Deleted Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }

}
