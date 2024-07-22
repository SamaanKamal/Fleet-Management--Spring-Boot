package com.example.FleetManagementDemo.Helpers.BookingHelper;

import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Entity.User;


public class BookingRequest {
    private Trip trip;


    private User user;

    private int seatNumber;

    public BookingRequest() {
    }

    public BookingRequest(Trip trip, User user, int seatNumber) {
        this.trip = trip;
        this.user = user;
        this.seatNumber = seatNumber;
    }

    public Trip getTrip() {
        return trip;
    }

    public User getUser() {
        return user;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
