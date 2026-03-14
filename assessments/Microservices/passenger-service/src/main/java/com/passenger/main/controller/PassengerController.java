package com.passenger.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passenger.main.services.PassengerService;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengerdetails")
    public String passengerDetails() {
        return passengerService.getPassengerDetails();
    }

}