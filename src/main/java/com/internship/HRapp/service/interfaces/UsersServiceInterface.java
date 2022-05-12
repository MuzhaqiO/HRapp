package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.UsersDTO;
import com.internship.HRapp.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UsersServiceInterface {


    Users getUserById(UUID userId);

    Users getUserByUsername(String username);

    List<Users> getUsers();

    Users addNewUsers(Users users);

    String deleteUsersById(UUID userId);

    Users updateUsers(Users users);
}
