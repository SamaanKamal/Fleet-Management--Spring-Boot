package com.example.FleetManagementDemo.Helpers.BusHelper;

import jakarta.persistence.Column;

public class BusRequest {
    private String registrationNumber;

    private int capacity;

    public BusRequest() {
    }

    public BusRequest(String registrationNumber, int capacity) {
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
