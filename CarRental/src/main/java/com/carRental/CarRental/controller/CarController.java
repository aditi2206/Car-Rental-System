package com.carRental.CarRental.controller;

import com.carRental.CarRental.dto.CarDto;
import com.carRental.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    CarService carService;
    @PostMapping("/addCar")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto){
        CarDto newCar = carService.addCar(carDto);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);

    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id,  @RequestBody CarDto carDto){
        CarDto updateCar = carService.updateCar(id, carDto);
        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }


}
