package com.carRental.CarRental.service;

import com.carRental.CarRental.dto.CarDto;
import com.carRental.CarRental.entity.Car;
import com.carRental.CarRental.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;


    public CarDto addCar(CarDto carDto){
        Car car = new Car();
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setPrice(carDto.getPrice());
        car.setFuelType(carDto.getFuelType());
        car.setTransmissionType(carDto.getTransmissionType());
        car.setMileage(carDto.getMileage());
        car.setLicensePlateNumber(carDto.getLicensePlateNumber());
        car.setNumberOfSeats(carDto.getNumberOfSeats());
        car.setCarType(carDto.getCarType());
        car.setColor(carDto.getColor());
        car.setRentalRatePerDay(carDto.getRentalRatePerDay());
        car.setDescription(carDto.getDescription());
        car.setAvailable(true);

        carRepository.save(car);

        return modelMapper.map(car, CarDto.class);

    }

    public CarDto updateCar(Long id, CarDto carDto){
          Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found!"));
          if(carDto.getMake() != null){
              car.setMake(carDto.getMake());
          }
          if(carDto.getModel() != null){
              car.setModel(carDto.getModel());
          }
          if(carDto.getYear() != null){
              car.setYear(carDto.getYear());
          }
          if(carDto.getPrice() != null){
              car.setPrice(carDto.getPrice());
          }
          if(carDto.getFuelType() != null){
              car.setFuelType(carDto.getFuelType());
          }
          if(carDto.getTransmissionType() !=null){
              car.setTransmissionType(carDto.getTransmissionType());
          }
          if(carDto.getMileage() != null){
              car.setMileage(carDto.getMileage());
          }
          if(carDto.getLicensePlateNumber() != null){
              car.setLicensePlateNumber(carDto.getLicensePlateNumber());
          }
          if(carDto.getCarType() != null){
              car.setCarType(carDto.getCarType());
          }
          if(carDto.getNumberOfSeats() != null){
              car.setNumberOfSeats(carDto.getNumberOfSeats());
          }
          if(carDto.getColor() != null){
              car.setColor(carDto.getColor());
          }
          if(carDto.getRentalRatePerDay() != null){
              car.setRentalRatePerDay(carDto.getRentalRatePerDay());
          }
          if(carDto.getDescription() != null){
              car.setDescription(carDto.getDescription());
          }
          car.setAvailable(carDto.isAvailable());

          carRepository.save(car);

          return modelMapper.map(car, CarDto.class);
    }
}
