package com.carRental.CarRental.service;

import com.carRental.CarRental.dto.BookingRequestDto;
import com.carRental.CarRental.dto.BookingResponseDto;
import com.carRental.CarRental.dto.CarDto;
import com.carRental.CarRental.entity.*;
import com.carRental.CarRental.repository.BookedCarRepository;
import com.carRental.CarRental.repository.BookingsRepository;
import com.carRental.CarRental.repository.CarRepository;
import com.carRental.CarRental.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    CarService carService;

    @Autowired
    BookedCarRepository bookedCarRepository;

    @Autowired
    ModelMapper mapper;

    public BookingResponseDto bookCar(BookingRequestDto bookingRequestDto){
        User user = userRepository.findById(bookingRequestDto.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Car car = carRepository.findById(bookingRequestDto.getCar_id())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        List<Car> carList = carService.searchAvailableCars(bookingRequestDto.getStartDate(), bookingRequestDto.getEndDate());


        if(!carList.contains(car)){
            throw new RuntimeException("Car is not available for the selected dates");
        }
//        for(Car carr : carList){
//            System.out.println();
//        }

        Bookings bookings = new Bookings();
        bookings.setStartDate(bookingRequestDto.getStartDate());
        bookings.setEndDate(bookingRequestDto.getEndDate());
        bookings.setPickupVenue(bookingRequestDto.getPickupVenue());
        bookings.setReturnVenue(bookingRequestDto.getReturnVenue());
        bookings.setUser(user);
        bookings.setCar(car);
        bookings.setStatus(BookingStatus.CONFIRMED);
        bookingsRepository.save(bookings);

        BookedCars bookedCar = new BookedCars();
        bookedCar.setCar(car);
        bookedCar.setUser(user);
        bookedCar.setStartDate(bookingRequestDto.getStartDate());
        bookedCar.setEndDate(bookingRequestDto.getEndDate());
        bookedCarRepository.save(bookedCar);

        BookingResponseDto response = new BookingResponseDto();
        response.setCarId(car.getCar_id());
        response.setUserId(user.getUserId());
        response.setStartDate(bookingRequestDto.getStartDate());
        response.setEndDate(bookingRequestDto.getEndDate());
        response.setStatus(bookings.getStatus());


        return mapper.map(response, BookingResponseDto.class);

    }


}
