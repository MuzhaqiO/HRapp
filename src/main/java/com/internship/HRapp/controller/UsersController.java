package com.internship.HRapp.controller;

import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UsersStatusDTO;
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
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userServiceInterface.addNewUser(userCreateDTO));
    }
    @PutMapping("updateUser/{userId}")
    public void updateUser(@RequestParam UserCreateDTO userCreateDTO){
        userServiceInterface.updateUser(userCreateDTO);
    }
    @PatchMapping("updateUsersStatus/{userId}")
    public void updateUsersStatus(@RequestParam UsersStatusDTO usersStatusDTO){
        userServiceInterface.updateUsersStatus(usersStatusDTO);
    }
    /*@PutMapping("updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userServiceInterface.updateUser(userId, userDTO));
    }*/
}