//package com.carRental.CarRental.service;
//
//import com.carRental.CarRental.entity.Role;
//import com.carRental.CarRental.dto.AdminLoginDto;
//import com.carRental.CarRental.dto.LoginResponseAdminDto;
//import com.carRental.CarRental.dto.RequestAdminDto;
//import com.carRental.CarRental.dto.ResponseAdminDto;
//import com.carRental.CarRental.entity.Admin;
//import com.carRental.CarRental.repository.AdminRepository;
//import com.carRental.CarRental.util.JwtToken;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AdminService {
//    @Autowired
//    AdminRepository adminRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    private JwtToken jwtToken;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public ResponseAdminDto registerAdmin(RequestAdminDto requestAdminDto) {
//        if (adminRepository.existsByUsername(requestAdminDto.getUsername())) {
//            throw new RuntimeException("Username already exists!");
//        }
//        if (requestAdminDto.getUsername() == null || requestAdminDto.getPassword() == null) {
//            throw new RuntimeException("Username and password required!");
//        }
//        String encodedPassword = passwordEncoder.encode(requestAdminDto.getPassword());
//
//        Admin newAdmin = new Admin();
//        newAdmin.setName(requestAdminDto.getName());
//        newAdmin.setPhone_no(requestAdminDto.getPhone_no());
//        newAdmin.setEmail(requestAdminDto.getEmail());
//        newAdmin.setUsername(requestAdminDto.getUsername());
//        newAdmin.setPassword(encodedPassword);
//        newAdmin.setRole(Role.ADMIN);
//
//        adminRepository.save(newAdmin);
//
//        return modelMapper.map(newAdmin, ResponseAdminDto.class);
//    }
//
//  /*  public LoginResponseAdminDto loginAdmin(AdminLoginDto adminLoginDto) {
//        //System.out.println("Login attempt with username: " + adminLoginDto.getUsername() + " " + adminLoginDto.getPassword());
//        Optional<Admin> optionalAdmin = adminRepository.findByUsername(adminLoginDto.getUsername());
//        System.out.println("Login attempt with username: " + adminLoginDto.getUsername());
//        if (optionalAdmin.isPresent()) {
//            Admin admin = optionalAdmin.get();
//
//            boolean passwordMatches = bCryptPasswordEncoder.matches(adminLoginDto.getPassword(), admin.getPassword());
//            System.out.println("Password matches: " + passwordMatches);
//
//            if (bCryptPasswordEncoder.matches(adminLoginDto.getPassword(), admin.getPassword())) {
//                String token = jwtToken.generateToken(admin.getUsername());
//                System.out.println("Generated JWT token: " + token);
//                LoginResponseAdminDto dto = new LoginResponseAdminDto();
//                dto.setAdmin_id(admin.getAdmin_id());
//                dto.setName(admin.getName());
//                dto.setEmail(admin.getEmail());
//                dto.setPhone_no(admin.getPhone_no());
//                dto.setToken(token);
//
//                return dto;
//            } else {
//                throw new RuntimeException("Invalid password!");
//            }
//        } else {
//            throw new RuntimeException("Admin not found!");
//        }
//    }
//
//   */
//}
