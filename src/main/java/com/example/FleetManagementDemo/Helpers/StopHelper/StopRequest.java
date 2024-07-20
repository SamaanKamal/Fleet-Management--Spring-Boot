package com.example.FleetManagementDemo.Helpers.StopHelper;

import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Entity.Trip;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class StopRequest {
    private Trip trip;

    private City city;

    private int stopOrder;

    public StopRequest() {
    }

    public StopRequest(Trip trip, City city, int stopOrder) {
        this.trip = trip;
        this.city = city;
        this.stopOrder = stopOrder;
    }

    public Trip getTrip() {
        return trip;
    }

    public City getCity() {
        return city;
    }

    public int getStopOrder() {
        return stopOrder;
    }
}
