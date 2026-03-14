package com.passenger.main.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CARENTALS-SERVICE", fallback = CarRentalFallback.class)
public interface CarRentalFeignClient {

    @GetMapping("/rentalcardetails")
    String getRentalCars();

}