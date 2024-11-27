//package com.carRental.CarRental.controller;
//
//import com.carRental.CarRental.dto.AdminLoginDto;
//import com.carRental.CarRental.dto.LoginResponseAdminDto;
//import com.carRental.CarRental.dto.RequestAdminDto;
//import com.carRental.CarRental.dto.ResponseAdminDto;
//import com.carRental.CarRental.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//
//    @PostMapping("/registerAdmin")
//    public ResponseEntity<ResponseAdminDto> registerAdmin(@RequestBody RequestAdminDto adminDto){
//        ResponseAdminDto registerAdmin = adminService.registerAdmin(adminDto);
//        return new ResponseEntity<>(registerAdmin, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/loginAdmin")
//    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDto adminLoginDto) {
//        try {
//            // Authenticate the username and password
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            adminLoginDto.getUsername(),
//                            adminLoginDto.getPassword()
//                    )
//            );
//
//            // If authentication is successful, call the service method to generate a JWT
//            LoginResponseAdminDto dto = adminService.loginAdmin(adminLoginDto);
//            return new ResponseEntity<>(dto, HttpStatus.OK);
//
//        } catch (UsernameNotFoundException e) {
//            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("Invalid credentials!", HttpStatus.UNAUTHORIZED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("An error occurred during login", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    }
//
//
//
//
