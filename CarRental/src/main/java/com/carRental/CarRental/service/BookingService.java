package com.carRental.CarRental.service;

import com.carRental.CarRental.dto.BookingRequestDto;
import com.carRental.CarRental.dto.BookingResponseDto;
import com.carRental.CarRental.entity.BookingStatus;
import com.carRental.CarRental.entity.Bookings;
import com.carRental.CarRental.entity.Car;
import com.carRental.CarRental.entity.User;
import com.carRental.CarRental.repository.BookingsRepository;
import com.carRental.CarRental.repository.CarRepository;
import com.carRental.CarRental.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    ModelMapper mapper;

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto){
        User user = userRepository.findById(bookingRequestDto.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Car car = carRepository.findById(bookingRequestDto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Bookings bookings = new Bookings();
        bookings.setStartDate(bookingRequestDto.getStartDate());
        bookings.setEndDate(bookingRequestDto.getEndDate());
        bookings.setPickupVenue(bookingRequestDto.getPickupVenue());
        bookings.setReturnVenue(bookingRequestDto.getReturnVenue());
        bookings.setUser(user);
        bookings.setCar(car);
        bookings.setStatus(BookingStatus.PENDING);
        bookingsRepository.save(bookings);

        return mapper.map(bookings, BookingResponseDto.class);

    }


}
