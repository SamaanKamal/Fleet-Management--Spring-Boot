package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByStartCityIdAndEndCityId(Long startCityId, Long endCityId);
}
