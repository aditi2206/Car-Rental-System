package com.carRental.CarRental.controller;

import com.carRental.CarRental.dto.CarDto;
import com.carRental.CarRental.entity.Car;
import com.carRental.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/search")
    public List<CarDto> searchCars(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {

        List<CarDto> carDtoList = new ArrayList<>();

         List<Car> carList = carService.searchAvailableCars(startDate, endDate);
         for(Car car : carList){
            CarDto carDto = new CarDto();
            carDto.setCar_id(car.getCar_id());
            carDto.setMake(car.getMake());
            carDto.setModel(car.getModel());
            carDto.setYear(car.getYear());
            carDto.setPrice(car.getPrice());
            carDto.setFuelType(car.getFuelType());
            carDto.setTransmissionType(car.getTransmissionType());
            carDto.setMileage(car.getMileage());
            carDto.setLicensePlateNumber(car.getLicensePlateNumber());
            carDto.setNumberOfSeats(car.getNumberOfSeats());
            carDto.setCarType(car.getCarType());
            carDto.setColor(car.getColor());
            carDto.setRentalRatePerDay(car.getRentalRatePerDay());
            carDto.setDescription(car.getDescription());

            carDtoList.add(carDto);

        }
         return carDtoList;
    }

}
