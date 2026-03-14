package com.passenger.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passenger.main.feign.CarRentalFeignClient;

@Service
public class PassengerServiceImple implements PassengerService {

    @Autowired
    private CarRentalFeignClient carRentalFeignClient;

    @Override
    public String getPassengerDetails() {

        String carDetails = carRentalFeignClient.getRentalCars();

        return "Passenger Name: Rahul\nRental Cars:\n" + carDetails;
    }
}