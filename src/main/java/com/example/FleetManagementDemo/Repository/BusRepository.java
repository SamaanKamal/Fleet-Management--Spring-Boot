package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
