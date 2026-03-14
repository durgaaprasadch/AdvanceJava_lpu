package com.carrentals.main.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carrentals.main.dto.CarRentalDTO;

@Service
public class CarRentalServiceImple implements CarRentalService {

    @Override
    public List<CarRentalDTO> getRentalCars() {

        return Arrays.asList(
                new CarRentalDTO(1,"BMW"),
                new CarRentalDTO(2,"Audi"),
                new CarRentalDTO(3,"Swift")
        );
    }
}