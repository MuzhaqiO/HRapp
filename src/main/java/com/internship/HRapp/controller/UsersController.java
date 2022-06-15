package com.internship.HRapp.controller;

import com.internship.HRapp.dto.projectsDto.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDto.AssignRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateUsersRoleDto;
import com.internship.HRapp.dto.userDto.*;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "hr_management/user")
@RequiredArgsConstructor
public class UsersController {
    private final UserServiceInterface userServiceInterface;

    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok(userServiceInterface.login(loginDTO));
    }

    @GetMapping("getAll")
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

    @PostMapping("/addNewUser")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO)
            throws Exception {
        return ResponseEntity.ok(userServiceInterface.addNewUser(userCreateDTO));
    }

    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserUpdateDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.ok(userServiceInterface.updateUser(userUpdateDTO));
    }

    @PatchMapping("updateUsername/{userId}")
    public ResponseEntity<UsernameDTO> updateUsername(@PathVariable UUID userId, @RequestBody UsernameDTO usernameDTO) {
        return ResponseEntity.ok(userServiceInterface.updateUsername(userId, usernameDTO));
    }

    @PatchMapping("updateUsersStatus/{userId}")
    public ResponseEntity<UserDTO> updateUsersStatus(@PathVariable UUID userId, @RequestBody UsersStatusDTO usersStatusDTO) {
        return ResponseEntity.ok(userServiceInterface.updateUsersStatus(userId, usersStatusDTO));
    }

    @PatchMapping("assignRole/{userId}")
    public ResponseEntity<AssignRoleDTO> assignRoleToUser(@PathVariable UUID userId, @RequestParam UUID roleId) {
        return ResponseEntity.ok(userServiceInterface.assignRoleToUser(userId, roleId));
    }

    @PatchMapping("removeRole/{userId}")
    public ResponseEntity<UpdateRoleDTO> removeRoleFromUser(@PathVariable UUID userId, @RequestParam UUID roleId) {
        return ResponseEntity.ok(userServiceInterface.removeRoleFromUser(userId, roleId));
    }

    @PatchMapping("assignProject/{userId}")
    public ResponseEntity<ProjectAssignDTO> assignProjectToUser(@PathVariable UUID userId, @RequestParam UUID projectId) {
        return ResponseEntity.ok(userServiceInterface.assignProjectToUser(userId, projectId));
    }

    @PatchMapping("removeProject/{userId}")
    public ResponseEntity<ProjectAssignDTO> removeProjectFromUser(@PathVariable UUID userId, @RequestParam UUID projectId) {
        return ResponseEntity.ok(userServiceInterface.removeProjectFromUser(userId, projectId));
    }

    @PostMapping("updateUser/{userId}")
    public ResponseEntity<UpdateRoleDTO> updateUserRole(@PathVariable UUID userId, @RequestBody UpdateUsersRoleDto requestDto) {
        return ResponseEntity.ok(userServiceInterface.updateRole(userId, requestDto));
    }

    @GetMapping("getUsersByRole/{roleId}")
    public ResponseEntity<List<UserDTO>> getUserByRole(@PathVariable UUID roleId) {
        return ResponseEntity.ok(userServiceInterface.getUserByRoleId(roleId));
    }

    @GetMapping("getUsersByProject/{projectId}")
    public ResponseEntity<List<UserDTO>> getUserByProject(@PathVariable UUID projectId) {
        return ResponseEntity.ok(userServiceInterface.getUserByProjectId(projectId));
    }

    @PatchMapping("/changePassword")
    public void changePassword(@RequestBody PasswordDTO passwordDTO) {
        userServiceInterface.changePassword(passwordDTO);
    }
}