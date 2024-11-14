package com.carRental.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String first_name;
    private String last_name;
    private String address;
    private String phone_no;
    private String license_no;
    private String email;
}

