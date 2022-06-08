package com.internship.HRapp.controller;

import com.internship.HRapp.configuration.JwtUtil;
import com.internship.HRapp.dto.userDTO.AuthResponseDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UserLoginDTO;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserServiceInterface userServiceInterface;
    private final AuthenticationManager authenticationManager;
    private  final JwtUtil jwtTokenUtil;


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userServiceInterface
                .loadUserByUsername(loginDTO.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDTO(jwt));
    }
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
//    @PostMapping("/edit-password/{userId}")
//    public ResponseEntity<UserDTO> editPassword(@PathVariable UUID userID, @RequestBody PasswordUpdate passwordUpdate){
//        return ResponseEntity.ok(userServiceInterface.editPassword(userID, passwordUpdate));
//    }
}