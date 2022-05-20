package com.internship.HRapp.controller;

import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserServiceInterface userServiceInterface;
    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userServiceInterface.getUsers());
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userServiceInterface.getUserByUsername(username));
    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId){
        return ResponseEntity.ok(userServiceInterface.getUserById(userId));
    }
    @PostMapping("addNewUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userServiceInterface.addNewUsers(userDTO));
    }
}