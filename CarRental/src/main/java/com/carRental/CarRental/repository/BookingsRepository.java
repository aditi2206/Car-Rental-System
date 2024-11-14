package com.carRental.CarRental.repository;

import com.carRental.CarRental.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUser_UserId(Long userId);
}
