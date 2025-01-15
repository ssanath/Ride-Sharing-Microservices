package com.example.driver_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.driver_service.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
