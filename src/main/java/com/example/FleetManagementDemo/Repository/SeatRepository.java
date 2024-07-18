package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
