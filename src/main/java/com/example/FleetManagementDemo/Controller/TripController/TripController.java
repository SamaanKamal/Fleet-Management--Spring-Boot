package com.example.FleetManagementDemo.Controller.TripController;

import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.TripHelper.TripRequest;
import com.example.FleetManagementDemo.Helpers.TripHelper.TripResponse;
import com.example.FleetManagementDemo.Service.TripService.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Trips")
public class TripController {

    @Autowired
    private ITripService tripService;

    @GetMapping
    public ResponseEntity<TripResponse> fetchAllTrips(){
        List<Trip> trips = tripService.getAllTrips();
        if(trips==null){
            return ResponseEntity.notFound().build();
        }
        TripResponse tripResponse  = new TripResponse(trips);
        return ResponseEntity.ok(tripResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trip> fetchTrip(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Trip trip = tripService.getTripDetails(id);
        if(trip ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody TripRequest tripRequest){
        if(tripRequest==null){
            return ResponseEntity.badRequest().build();
        }
        Trip trip = tripService.createTrip(tripRequest);
        if(trip!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(trip);
        }
        return  ResponseEntity.internalServerError().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable("id") Long id,@RequestBody TripRequest tripRequest){
        if(tripRequest==null||id ==null){
            return ResponseEntity.badRequest().build();
        }
        Trip trip = tripService.updateTrip(tripRequest,id);
        if(trip!=null){
            return ResponseEntity.status(HttpStatus.OK).body(trip);
        }
        return  ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable("id") Long id){
        if(id ==null){
            return ResponseEntity.badRequest().build();
        }
        boolean isDeleted= tripService.deleteTrip(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Trip Deleted Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }

}
