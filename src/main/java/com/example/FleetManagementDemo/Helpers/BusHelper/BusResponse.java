package com.example.FleetManagementDemo.Helpers.BusHelper;

import com.example.FleetManagementDemo.Entity.Bus;

import java.util.List;

public class BusResponse {

    private List<Bus> buses;

    public BusResponse(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Bus> getBuses() {
        return buses;
    }
}
