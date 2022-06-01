package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.service.concretes.UserServiceImpl;
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
    private final UserServiceImpl userService;
    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @PostMapping("addNewUser")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userService.addNewUser(userCreateDTO));
    }
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserCreateDTO> updateUser(@RequestBody UserCreateDTO userCreateDTO){
        return ResponseEntity.ok(userService.updateUser(userCreateDTO));
    }
    @PatchMapping("updateUsersStatus/{userId}")
    public ResponseEntity<UsersStatusDTO> updateUsersStatus(@PathVariable UUID userId, @RequestBody UsersStatusDTO usersStatusDTO){
        return ResponseEntity.ok(userService.updateUsersStatus(userId, usersStatusDTO));
    }
    @PatchMapping("assignRole/{userId}")
    public ResponseEntity<AssignRoleDTO> assignRoleToUser(@PathVariable UUID userId, @RequestBody AssignRoleDTO assignRoleDTO){
        return ResponseEntity.ok(userService.assignRoleToUser(userId, assignRoleDTO));
    }
    @PatchMapping("assignProject/{userId}")
    public ResponseEntity<ProjectAssignDTO> assignProjectToUser(@PathVariable UUID userId, @RequestBody ProjectAssignDTO projectAssignDTO){
        return ResponseEntity.ok(userService.assignProjectToUser(userId, projectAssignDTO));
    }
}