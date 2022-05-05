package com.internship.HRapp.service.concretes;

import com.internship.HRapp.entity.Users;
import com.internship.HRapp.repository.UsersRepo;
import com.internship.HRapp.service.interfaces.UsersServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersServiceInterface {

    private final UsersRepo usersRepo;

    @Override
    public void getUser(Users users) {
    }

    @Override
    public List<Users> getUsers() {
        return null;
    }

    @Override
    public void addNewUsers(Users users) {

    }

    @Override
    public void deleteUsers(UUID usersId) {

    }

    @Override
    public void updateUsers(UUID usersId, String firstName, String email) {

    }
}
