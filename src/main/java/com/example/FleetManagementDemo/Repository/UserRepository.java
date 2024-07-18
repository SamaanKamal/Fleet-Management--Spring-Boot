package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
