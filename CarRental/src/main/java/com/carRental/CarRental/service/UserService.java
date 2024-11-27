package com.carRental.CarRental.service;

import com.carRental.CarRental.dto.*;
import com.carRental.CarRental.entity.Bookings;
import com.carRental.CarRental.entity.User;
import com.carRental.CarRental.repository.BookingsRepository;
import com.carRental.CarRental.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingsRepository bookingsRepository;

  //  @Autowired
    //private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

  //  @Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto registerUser(UserDto userDto){
        if(userRepository.existsByUsername(userDto.getUsername())){
            throw new RuntimeException("Username already exists!");
        }
        if(userDto.getPassword() == null || userDto.getUsername() == null){
            throw new RuntimeException("Username and password required!");
        }

        //String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User new_user = new User();
        new_user.setFirst_name(userDto.getFirst_name());
        new_user.setLast_name(userDto.getLast_name());
        new_user.setEmail(userDto.getEmail());
        new_user.setUsername(userDto.getUsername());
        new_user.setPassword(userDto.getPassword());

        userRepository.save(new_user);

        return modelMapper.map(new_user, UserDto.class);
    }

    public String loginUser(UserLoginDto userLoginDto){
        User user = userRepository.findByUsername(userLoginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if(userLoginDto.getPassword().equals(user.getPassword())){
            return "Login successful!";
        }
        else{
            return "Login unsuccessful!";
        }
    }

    public UpdateUserDto updateUser(Long id, UpdateUserDto updateUserDto){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (updateUserDto.getFirst_name() != null) {
            existingUser.setFirst_name(updateUserDto.getFirst_name());
        }
        if (updateUserDto.getLast_name() != null) {
            existingUser.setLast_name(updateUserDto.getLast_name());
        }
        if (updateUserDto.getAddress() != null) {
            existingUser.setAddress(updateUserDto.getAddress());
        }
        if (updateUserDto.getLicense_no() != null) {
            existingUser.setLicense_no(updateUserDto.getLicense_no());
        }
        if (updateUserDto.getPhone_no() != null) {
            existingUser.setPhone_no(updateUserDto.getPhone_no());
        }

        userRepository.save(existingUser);

        return modelMapper.map(existingUser, UpdateUserDto.class);
    }

    public UserProfileDto getUserById(Long id){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("User does not exist!"));

      //  List<Bookings> bookingsList = bookingsRepository.findByUserId(id);

        List<BookingsDto> bookingsDtoList = new ArrayList<>();
        /*for(Bookings b : bookingsList){
            BookingsDto bookingsDto = new BookingsDto();
            bookingsDto.setStartDate(b.getStartDate());
            bookingsDto.setEndDate(b.getEndDate());
            bookingsDto.setPickupVenue(b.getPickupVenue());
            bookingsDto.setReturnVenue(b.getReturnVenue());
            bookingsDto.setCarMake(b.getCar().getMake());
            bookingsDto.setCarModel(b.getCar().getModel());
            bookingsDto.setCarLicensePlate(b.getCar().getLicensePlateNumber());

            bookingsDtoList.add(bookingsDto);

        }
         */

        UserProfileDto userProfileDto = modelMapper.map(existingUser,UserProfileDto.class);
        userProfileDto.setBookingHistory(bookingsDtoList);
        return userProfileDto;
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        userRepository.delete(user);

    }




}
