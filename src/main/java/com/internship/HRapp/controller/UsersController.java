package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Users;
import com.internship.HRapp.service.concretes.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersServiceImpl usersServiceImpl;

    @GetMapping
    public List<Users> getUsers() {
        return usersServiceImpl.getUsers();
        }
        public void getUser(Users user){
        usersServiceImpl.getUser(user);
        }
    @PostMapping
    public void registerNewUsers(@RequestBody Users users){
        usersServiceImpl.addNewUsers(users);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUsers(@PathVariable("userId") UUID userId){
        usersServiceImpl.deleteUsers(userId);
    }
    @PutMapping()
    public void updateUsers(
            @RequestParam UUID userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String email){
        usersServiceImpl.updateUsers(userId, firstName, email);
    }
}