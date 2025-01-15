package com.example.driver_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id private Long id;
    @Column private String name;
    @Column private String licenseNumber;
    @Column private String vehicleType;
    @Column private boolean availability;

    public Driver() {}
    public Driver(Long id, String name, String licenseNumber, String vehicleType, boolean availability) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.availability = availability;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
