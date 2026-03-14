package com.carrentals.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carrentals.main.entities.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {

}