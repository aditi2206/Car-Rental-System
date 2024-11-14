package com.carRental.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    private Long carId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupVenue;
    private String returnVenue;
}
