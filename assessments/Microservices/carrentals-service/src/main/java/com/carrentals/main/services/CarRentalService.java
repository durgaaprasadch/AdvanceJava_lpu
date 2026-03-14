package com.carrentals.main.services;

import java.util.List;
import com.carrentals.main.dto.CarRentalDTO;

public interface CarRentalService {

    List<CarRentalDTO> getRentalCars();

}