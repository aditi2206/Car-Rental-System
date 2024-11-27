//package com.carRental.CarRental.security;
//
//import com.carRental.CarRental.entity.Admin;
//import com.carRental.CarRental.repository.AdminRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class AdminDetailService implements UserDetailsService {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Transactional
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.println("Attempting to load admin with username: " + username);
//        Admin admin = adminRepository.findByUsername(username)
//                .orElseThrow(() ->  new UsernameNotFoundException("Admin not found with username" + username));
//        System.out.println("this is from loadUserByUsername" + " " +  admin.getPassword());
//        return new AdminDetails(admin);
//    }
//}
