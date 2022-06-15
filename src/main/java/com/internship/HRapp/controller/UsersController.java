package com.internship.HRapp.controller;

import com.internship.HRapp.dto.projectDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.security.MyUserDetails;
import com.internship.HRapp.service.interfaces.UserServiceInterface;

import com.internship.HRapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UsersController {
    private final UserServiceInterface userServiceInterface;
    private final MyUserDetails myUserDetails;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

//    @PostMapping(value = "/login")
//    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//        final UserDetails userDetails = myUserDetails
//                .loadUserByUsername(loginDTO.getUsername());
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthResponseDTO(jwt));
//    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok(userServiceInterface.login(loginDTO));
    }
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userServiceInterface.getUsers());
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userServiceInterface.getUserByUsername(username));
    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserCreateDTO> getUserById(@PathVariable UUID userId){
        return ResponseEntity.ok(userServiceInterface.getUserById(userId));
    }
    @GetMapping("userProfile/{userId}")
    public ResponseEntity<UserCreateDTO> getUserProfile(@PathVariable UUID userId){
        return ResponseEntity.ok(userServiceInterface.getUserProfile(userId));
    }


    @GetMapping("getUsersByProject/{projectId}")
    public ResponseEntity<List<UserDTO>> getUserByProject(@PathVariable UUID projectId){
        return ResponseEntity.ok(userServiceInterface.getUserByProjectId(projectId));
    }
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("addNewUser")
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userServiceInterface.addNewUser(userCreateDTO));
    }
    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping("updateUser/{userId}")
    public void updateUser(@RequestBody UserCreateDTO userCreateDTO){

        userServiceInterface.updateUser(userCreateDTO);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping("updateUserDTO/{userId}")
    public void updateUserDTO(@RequestBody UserDTO userDTO){
        userServiceInterface.updateUserDTO(userDTO);
    }
    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping("updateUserByUsername/{username}")
    public void updateUserByUsername(@RequestBody UserDTO userDTO){
        userServiceInterface.updateUserByUsername(userDTO);
    }
    @PatchMapping("updateUsersStatus/{userId}")
    public void updateUsersStatus(@RequestParam UsersStatusDTO usersStatusDTO){
        userServiceInterface.updateUsersStatus(usersStatusDTO);
    }

    @PatchMapping("assignProjectToUser/{userId}/projectId/{projectId}")
    public ResponseEntity<ProjectAssignDTO> assignProjectToUser(@PathVariable UUID userId, @PathVariable UUID projectId){
        return ResponseEntity.ok(userServiceInterface.assignProjectToUser(userId, projectId));
    }
    /*@PutMapping("updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userServiceInterface.updateUser(userId, userDTO));
    }*/
    @DeleteMapping("deleteUser/{userId}")
    public String deleteUser(@PathVariable UUID userId){
        return userServiceInterface.deleteUserByUserId(userId);
    }
}