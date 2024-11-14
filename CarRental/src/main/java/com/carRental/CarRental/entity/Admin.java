package com.carRental.CarRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    private String name;
    private int phone_no;
    private String email;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    
}
