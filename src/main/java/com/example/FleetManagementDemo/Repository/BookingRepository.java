package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByTripId(Long tripId);
}
