package com.example.FleetManagementDemo.Helpers.TripHelper;

import com.example.FleetManagementDemo.Entity.Trip;

import java.util.List;

public class TripResponse {
    List<Trip> trips;

    public TripResponse(List<Trip> trips) {
        this.trips = trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
