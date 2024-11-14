package com.carRental.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseAdminDto {
    private Long admin_id;
    private String name;
    private int phone_no;
    private String email;
    private String token;
}
