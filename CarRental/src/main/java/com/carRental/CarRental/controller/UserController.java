package com.carRental.CarRental.controller;

import com.carRental.CarRental.dto.UpdateUserDto;
import com.carRental.CarRental.dto.UserDto;
import com.carRental.CarRental.dto.UserLoginDto;
import com.carRental.CarRental.dto.UserProfileDto;
import com.carRental.CarRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
         
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.registerUser(userDto);
        return new ResponseEntity<UserDto>(userDto1, HttpStatus.CREATED);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDto userLoginDto){
        try {
            String message = userService.loginUser(userLoginDto);
            return new ResponseEntity<>(message, HttpStatus.OK);
//        } catch (UsernameNotFoundException e){
//            return new ResponseEntity<>("User not found!", HttpStatus.UNAUTHORIZED);
//        } catch (BadCredentialsException e){
//            return new ResponseEntity<>("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        } catch (Exception e){
            return new ResponseEntity<>("An error occurred!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto){
        try {
            UpdateUserDto updatedUser = userService.updateUser(id, updateUserDto);
            return new ResponseEntity<UpdateUserDto>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>("An error occurred while updating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            UserProfileDto userProfileDto = userService.getUserById(id);
            return new ResponseEntity<>(userProfileDto, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity("User deleted", HttpStatus.OK);
    }
}
