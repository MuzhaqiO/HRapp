package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.UsersDTO;
import com.internship.HRapp.entity.Users;
import com.internship.HRapp.mapper.UsersMapper;
import com.internship.HRapp.repository.RolesRepo;
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
    private final RolesRepo rolesRepo;
    private final UsersMapper usersMapper;
    @Override
    public Users getUserById(UUID userId) {
        return usersRepo.findById(userId).orElse(null);
    }
    @Override
    public Users getUserByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Users addNewUsers(Users users) {
        return usersRepo.save(users);
    }

    @Override
    public String deleteUsersById(UUID userId) {
        usersRepo.deleteById(userId);
        return "user removed {}" + userId;
    }

    @Override
    public Users updateUsers(Users users) {
        Users existingUser = usersRepo.findById(users.getUserId()).orElse(null);
        assert existingUser != null;
        existingUser.setUsername(users.getUsername());
        existingUser.setEmail(users.getEmail());
        return usersRepo.save(existingUser);
    }

}
