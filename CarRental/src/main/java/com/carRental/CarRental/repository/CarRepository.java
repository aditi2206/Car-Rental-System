package com.carRental.CarRental.repository;

import com.carRental.CarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
