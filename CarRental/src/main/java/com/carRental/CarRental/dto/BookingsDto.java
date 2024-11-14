package com.carRental.CarRental.dto;

import com.carRental.CarRental.entity.BookingStatus;
import com.carRental.CarRental.entity.Car;
import com.carRental.CarRental.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupVenue;
    private String returnVenue;
    private BookingStatus status;
    private String carMake;
    private String carModel;
    private String carLicensePlate;
    private Long userId;
    private String userName;

}
