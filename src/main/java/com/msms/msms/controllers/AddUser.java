package com.msms.msms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msms.msms.payloads.AddUserDto;
import com.msms.msms.payloads.ApiResponse;
import com.msms.msms.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddUser {

    private final UserService userService;
    
    public ResponseEntity<?> addUser(@Valid @RequestBody AddUserDto addUserDto){
        Long userId = userService.addUser(addUserDto);
        if (userId==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("User was not added.", false, userId, null));
        }
        return ResponseEntity.status(201).body(new ApiResponse("User has added successfully.", true, userId, null));
    }    
}
