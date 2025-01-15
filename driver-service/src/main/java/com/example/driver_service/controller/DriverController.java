package com.example.driver_service.controller;

import com.example.driver_service.model.Driver;
import com.example.driver_service.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/createDriver")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping("/getDriver/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllDrivers")
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @PutMapping("/updateDriver/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setLicenseNumber(updatedDriver.getLicenseNumber());
            driver.setVehicleType(updatedDriver.getVehicleType());
            driver.setAvailability(updatedDriver.isAvailability());
            driverRepository.save(driver);
            return ResponseEntity.ok(driver);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteDriver/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

