package com.example.FleetManagementDemo.Helpers.TripHelper;

import com.example.FleetManagementDemo.Entity.City;

import java.util.Date;

public class TripRequest {
    private City startCity;

    private City endCity;
    private Date departureTime;

    public TripRequest() {
    }

    public TripRequest(City startCity, City endCity, Date departureTime) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.departureTime = departureTime;
    }

    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }
}




