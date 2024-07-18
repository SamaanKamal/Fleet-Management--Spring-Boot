package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
