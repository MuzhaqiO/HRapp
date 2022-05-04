package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Users;
import com.internship.HRapp.repository.UsersRepo;

import java.util.List;

public interface UsersServiceInterface {

    void getUser(Users users);

    List<Users> getUsers();

    void addNewUsers(Users users);

    void deleteUsers(Long usersId);

    void updateUsers(Long usersId, String firstName, String email);
}
