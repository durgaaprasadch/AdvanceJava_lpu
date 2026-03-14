package com.passenger.main.feign;

import org.springframework.stereotype.Component;

@Component
public class CarRentalFallback implements CarRentalFeignClient {

    @Override
    public String getRentalCars() {
        return "CarRental Service is currently unavailable (Feign Fallback)";
    }
}