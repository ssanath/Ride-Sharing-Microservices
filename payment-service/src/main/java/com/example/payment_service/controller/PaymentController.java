package com.example.payment_service.controller;

import com.example.payment_service.model.Payment;
import com.example.payment_service.model.RideDTO;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/createPayment")
    public Payment createPayment(@RequestBody Payment payment) {
        String rideUrl = "http://ride-service/rides/getRide/" + payment.getRideId();
        ResponseEntity<RideDTO> rideResponse = restTemplate.getForEntity(rideUrl, RideDTO.class); // Fetch the DriverDTO
        RideDTO ride = rideResponse.getBody();  // Get the DriverDTO from the response
        if (ride == null) {
            throw new RuntimeException("Ride not found");  // If driver not found, throw error
        }
        payment.setCreatedAt(LocalDateTime.now());
        payment.setRideStatus(ride.getStatus());
        return paymentRepository.save(payment);
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllPayments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setPaymentStatus(updatedPayment.getPaymentStatus());
            paymentRepository.save(payment);
            return ResponseEntity.ok(payment);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

