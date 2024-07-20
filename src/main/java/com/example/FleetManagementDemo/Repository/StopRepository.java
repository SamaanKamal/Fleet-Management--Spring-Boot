package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop,Long> {
}
