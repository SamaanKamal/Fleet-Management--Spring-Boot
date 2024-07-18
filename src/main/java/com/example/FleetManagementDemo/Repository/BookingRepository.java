package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
