package com.example.payment_service.model;

import java.time.LocalDateTime;

public class RideDTO {
    private Long id;
    private Long userId;
    private Long driverId;
    private String startLocation;
    private String endLocation;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String driverName;
    private String driverLicenseNumber;
    private String driverVehicleType;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDriverName(String driverName) { this.driverName = driverName; }

    public String getDriverName() { return driverName; }

    public void setDriverLicenseNumber(String driverLicenseNumber) { this.driverLicenseNumber = driverLicenseNumber; }

    public String getDriverLicenseNumber() { return driverLicenseNumber; }

    public void setDriverVehicleType(String driverVehicleType) { this.driverVehicleType = driverVehicleType; }

    public String getDriverVehicleType() { return driverVehicleType; }

}