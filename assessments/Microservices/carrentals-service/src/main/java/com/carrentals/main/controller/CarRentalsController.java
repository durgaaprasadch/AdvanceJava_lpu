package com.carrentals.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentals.main.dto.CarRentalDTO;
import com.carrentals.main.services.CarRentalService;

@RestController
public class CarRentalsController {

    @Autowired
    private CarRentalService service;

    @GetMapping("/rentalcardetails")
    public List<CarRentalDTO> rentalCarDetails(){
        return service.getRentalCars();
    }

    @GetMapping("/bookingdetails")
    public String bookingDetails(){
        return "Car booking successful";
    }
}