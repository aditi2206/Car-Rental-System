package com.carRental.CarRental.controller;

import com.carRental.CarRental.dto.BookingRequestDto;
import com.carRental.CarRental.dto.BookingResponseDto;
import com.carRental.CarRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDto> createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        BookingResponseDto bookingResponseDto = bookingService.createBooking(bookingRequestDto);
        return new ResponseEntity<>(bookingResponseDto, HttpStatus.CREATED);
    }
}
