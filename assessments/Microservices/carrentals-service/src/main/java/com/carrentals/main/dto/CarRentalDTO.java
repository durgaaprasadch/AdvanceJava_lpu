package com.carrentals.main.dto;

public class CarRentalDTO {

    private int carId;
    private String carName;

    public CarRentalDTO(int carId, String carName) {
        this.carId = carId;
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }
}