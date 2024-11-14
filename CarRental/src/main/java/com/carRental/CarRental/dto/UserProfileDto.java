package com.carRental.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {
    private String first_name;
    private String last_name;
    private String address;
    private String phone_no;
    private String license_no;
    private String email;
    private List<BookingsDto> bookingHistory = new ArrayList<>();
}
