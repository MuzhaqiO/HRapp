package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("hr_menagement")
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UsersController {
    private final UserServiceInterface userServiceInterface;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok(userServiceInterface.login(loginDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userServiceInterface.getUsers());
    }

    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userServiceInterface.getUserByUsername(username));
    }

    @GetMapping("userId/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userServiceInterface.getUserById(userId));
    }

    @PatchMapping("assignRole")
    public void updateUsersStatus(@RequestBody AssignRoleDTO assignRoleDTO) {
        userServiceInterface.assignRole(assignRoleDTO);
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userServiceInterface.addNewUser(userCreateDTO));
    }

    @PutMapping("updateUser/{userId}")
    public void updateUser(@RequestBody UserCreateDTO userCreateDTO) {
        userServiceInterface.updateUser(userCreateDTO);
    }

    @PatchMapping("updateUsersStatus/{userId}")
    public void updateUsersStatus(@RequestParam UsersStatusDTO usersStatusDTO) {
        userServiceInterface.updateUsersStatus(usersStatusDTO);
    }

    @PatchMapping("/changePassword")
    public void changePassword(@RequestBody PasswordDTO passwordDTO) {
        userServiceInterface.changePassword(passwordDTO);
    }
}