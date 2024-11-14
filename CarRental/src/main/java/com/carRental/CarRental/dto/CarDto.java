package com.carRental.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDto {
    private Long carId;
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private boolean available;
    private String fuelType;
    private String transmissionType;
    private Double mileage;
    private String licensePlateNumber;
    private Integer numberOfSeats;
    private String carType;
    private String color;
    private Double rentalRatePerDay;
    private String description;
}
