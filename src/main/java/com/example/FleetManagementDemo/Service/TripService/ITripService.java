package com.example.FleetManagementDemo.Service.TripService;

import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.TripHelper.TripRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITripService {

    Trip createTrip(TripRequest tripRequest);


    Trip getTripDetails(Long id);

    List<Trip> findTripsByOriginAndDestination(Long originId, Long destinationId);

    Trip updateTrip(TripRequest tripRequest,Long id);

    boolean deleteTrip(Long id);
}
