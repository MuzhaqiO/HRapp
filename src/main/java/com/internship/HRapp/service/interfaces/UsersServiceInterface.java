package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UsersServiceInterface {

    void getUser(Users users);

    List<Users> getUsers();

    void addNewUsers(Users users);

    void deleteUsers(UUID usersId);

    void updateUsers(UUID usersId, String firstName, String email);
}
