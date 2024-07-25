package com.example.FleetManagementDemo.Helpers.SeatHelper;

import com.example.FleetManagementDemo.Entity.Seat;

import java.util.List;

public class SeatResponse {
    List<Seat> seats;

    public SeatResponse(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
