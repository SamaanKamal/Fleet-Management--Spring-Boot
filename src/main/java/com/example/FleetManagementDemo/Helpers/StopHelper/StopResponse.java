package com.example.FleetManagementDemo.Helpers.StopHelper;

import com.example.FleetManagementDemo.Entity.Stop;

import java.util.List;

public class StopResponse {

    List<Stop> stops;

    public StopResponse(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Stop> getStops() {
        return stops;
    }
}
