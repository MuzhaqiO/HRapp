package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Users;
import com.internship.HRapp.service.implementation.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hrmdb")
public class UsersController {
    private final UsersServiceImpl usersServiceImpl;

    @Autowired
    public UsersController(UsersServiceImpl usersServiceImpl) {
        this.usersServiceImpl = usersServiceImpl;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersServiceImpl.getUsers();
    }
    @GetMapping
    public void getUser(Users users){
        usersServiceImpl.getUser(users);
    }
    @PostMapping
    public void registerNewUsers(@RequestBody Users users){
        usersServiceImpl.addNewUsers(users);
    }
    @DeleteMapping(path = "{usersId}")
    public void deleteUsers(@PathVariable("usersId") Long usersId){
        usersServiceImpl.deleteUsers(usersId);
    }
    @PutMapping()
    public void updateUsers(
            @RequestParam Long usersId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String email){
        usersServiceImpl.updateUsers(usersId, firstName, email);
    }
}
