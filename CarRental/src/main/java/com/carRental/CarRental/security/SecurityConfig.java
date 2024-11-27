//package com.carRental.CarRental.security;
//
//import com.carRental.CarRental.Filter.JwtAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private AdminDetailService adminDetailService;
//
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF protection for testing
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/users/registerUser", "/users/loginUser").permitAll()
////                        .requestMatchers("/users/updateUser/**").permitAll()
////                        .requestMatchers("/users/getUserById/**").permitAll()
////                        .requestMatchers("/users/deleteUserById/**").permitAll()
////                        .requestMatchers("/api/cars/addCar").hasRole("ADMIN")
//                        .requestMatchers("/api/admin/registerAdmin").permitAll()
//                        .requestMatchers("/api/admin/loginAdmin").permitAll()
////                        .requestMatchers("/api/cars/updateCar/**").hasRole("ADMIN")
////                        .anyRequest().authenticated() // Any other request requires authentication
//                )
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT filter
//                .logout(logout -> logout.permitAll()); // Allow logout
//
//
//        return http.build();
//    }
//
//
//}
