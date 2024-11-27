//package com.carRental.CarRental.security;
//
//import com.carRental.CarRental.entity.Admin;
//import com.carRental.CarRental.service.AdminService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//
//public class AdminDetails  implements UserDetails {
//
//    private Admin admin;
//
//    public AdminDetails(Admin admin){
//        this.admin = admin;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(new SimpleGrantedAuthority(admin.getRole().name()));
//    }
//
//    @Override
//    public String getPassword() {
//        return admin.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return admin.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
