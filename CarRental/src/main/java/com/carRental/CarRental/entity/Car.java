package com.carRental.CarRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;
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

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Bookings> bookings = new ArrayList<>();

}
