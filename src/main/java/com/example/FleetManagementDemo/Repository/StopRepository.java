package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopRepository extends JpaRepository<Stop,Long> {
    List<Stop> findByTripIdOrderByStopOrderAsc(Long tripId);
}
