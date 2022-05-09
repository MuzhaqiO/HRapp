package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Users;
import com.internship.HRapp.service.concretes.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
@Transactional
public class UsersController {
    private final UsersServiceImpl usersServiceImpl;

    @GetMapping
    public List<Users> getUsers() {
        return usersServiceImpl.getUsers();
        }
        @GetMapping("id/{userId}")
    public Users getUserById(@PathVariable UUID userId){
        return usersServiceImpl.getUserById(userId);
        }
        @GetMapping("username/{username}")
    public Users getUserByUsername(@PathVariable String username){
        return usersServiceImpl.getUserByUsername(username);
    }
    @PostMapping
    public Users registerNewUsers(@RequestBody Users users){
        return usersServiceImpl.addNewUsers(users);
    }
    @DeleteMapping("del_id/{userId}")
    public String deleteUsersById(@PathVariable UUID userId){
        return usersServiceImpl.deleteUsersById(userId);
    }
    @DeleteMapping("del_username/{username}")
    public String deleteUsersByUsername(@PathVariable String username){
        return usersServiceImpl.deleteUsersByUsername(username);
    }
    @PutMapping("update/{userId}")
    public Users updateUsers(Users users){
        return usersServiceImpl.updateUsers(users);
    }
}