package com.apigateway.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userFallback")
    public String userFallback() {
        return "User Service is currently unavailable";
    }

    @GetMapping("/orderFallback")
    public String orderFallback() {
        return "Order Service is currently unavailable";
    }

    @GetMapping("/carrentalFallback")
    public String carrentalFallback() {
        return "CarRental Service is currently unavailable";
    }

    @GetMapping("/passengerFallback")
    public String passengerFallback() {
        return "Passenger Service is currently unavailable";
    }
}