package com.carRental.CarRental.dto;

import com.carRental.CarRental.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private Long bookingId;
    private Long carId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupVenue;
    private String returnVenue;
    private BookingStatus status; // e.g., "confirmed", "pending", etc.
    private double totalPrice;
}
