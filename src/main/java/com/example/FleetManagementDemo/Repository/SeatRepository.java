package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> getAllSeatsByBusId(Long busId);
}
