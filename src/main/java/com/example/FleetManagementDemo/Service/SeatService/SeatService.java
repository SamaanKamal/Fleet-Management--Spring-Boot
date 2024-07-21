package com.example.FleetManagementDemo.Service.SeatService;

import com.example.FleetManagementDemo.Entity.Bus;
import com.example.FleetManagementDemo.Entity.Seat;
import com.example.FleetManagementDemo.Repository.BusRepository;
import com.example.FleetManagementDemo.Repository.SeatRepository;
import com.example.FleetManagementDemo.Service.BusService.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService{

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BusService busService;

    @Override
    public List<Seat> getAvailableSeatsByBusId(Long busId) {
        Bus bus = busService.getBus(busId);
        return seatRepository.getAllSeatsByBusId(bus.getId());
    }

    @Override
    public Seat getSeatById(Long seatId) {
        return seatRepository.findById(seatId).orElseThrow(()-> new RuntimeException("Seat not found with id:"  + seatId));
    }
}
