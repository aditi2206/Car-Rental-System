package com.carRental.CarRental.dto;

import com.carRental.CarRental.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAdminDto {
    private String name;
    private int phone_no;
    private String email;

    @NotBlank(message = "username is required")
    private String username;
    private Role role;
}
