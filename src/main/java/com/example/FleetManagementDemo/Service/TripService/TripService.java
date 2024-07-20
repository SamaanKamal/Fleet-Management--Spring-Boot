package com.example.FleetManagementDemo.Service.TripService;

import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.TripHelper.TripRequest;
import com.example.FleetManagementDemo.Repository.TripRepository;
import com.example.FleetManagementDemo.Service.CityService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TripService implements ITripService{
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CityService cityService;
    @Override
    public Trip createTrip(TripRequest tripRequest) {
        Trip trip = new Trip();
        trip.setStartCity(cityService.getCityById(tripRequest.getStartCity().getId()));
        trip.setEndCity(cityService.getCityById(tripRequest.getEndCity().getId()));
        trip.setDepartureTime(new Date());
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getTripDetails(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: "+id));
    }

    @Override
    public List<Trip> findTripsByOriginAndDestination(Long originId, Long destinationId) {
        return tripRepository.findByStartCityIdAndEndCityId(originId, destinationId);
    }

    @Override
    public Trip updateTrip(TripRequest tripRequest, Long id) {
        Trip trip=tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: "+id));
        trip.setStartCity(tripRequest.getStartCity());
        trip.setEndCity(tripRequest.getEndCity());
        trip.setDepartureTime(new Date());
        tripRepository.save(trip);
        return trip;
    }

    @Override
    public boolean deleteTrip(Long id) {
        Trip deletedTrip =tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: "+id));
        if(deletedTrip!=null){
            tripRepository.delete(deletedTrip);
            return true;
        }
        return false;
    }
}
