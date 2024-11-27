package com.carRental.CarRental.repository;

import com.carRental.CarRental.entity.BookedCars;
import com.carRental.CarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookedCarRepository extends JpaRepository<BookedCars, Long> {
    @Query("SELECT bc.car FROM BookedCars bc WHERE" + "(bc.startDate >= :startDate AND bc.startDate <= :endDate) OR (bc.endDate >= :startDate AND bc.endDate <= :endDate)")
        List<Car> findBookedCarsWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}

/**

 1      24-NOV   25-NOV         car - 1,2,3,4
 2      27       29
 3      23NOV   24
 4        21      23

       24      26  ENTRY
     23    25
             26        27


                                            24                      24                  25                      25
    SELECT * FROM BOOKEDCARS BC WHERE (BC.STARTDATE >= 24 AND BC.startDate <= 26) OR (BC.endDate GREATER= 24 AND BC.endDate <= 26)


 */
