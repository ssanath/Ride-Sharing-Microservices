package com.example.payment_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id private Long id;
    @Column private Long rideId;
    @Column private double amount;
    @Column private String paymentStatus;
    @Column private String paymentMethod;
    @Column private LocalDateTime createdAt;
    @Column private String rideStatus;
    public Payment() {}
    public Payment(Long id, Long rideId, double amount, String paymentStatus,
                         String paymentMethod, LocalDateTime createdAt, String rideStatus) {
        this.id = id;
        this.rideId = rideId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.createdAt = createdAt;
        this.rideStatus = rideStatus;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setRideStatus(String rideStatus) { this.rideStatus = rideStatus; }

    public String getRideStatus() { return rideStatus; }
}