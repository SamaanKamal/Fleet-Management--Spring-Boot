package com.example.FleetManagementDemo.Service.SeatService;

import com.example.FleetManagementDemo.Entity.Seat;

import java.util.List;

public interface ISeatService {
    List<Seat> getAvailableSeatsByBusId(Long busId);

    Seat getSeatById(Long seatId);
}
