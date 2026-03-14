package com.carrentals.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarRental {

    @Id
    private int carId;
    private String carName;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}