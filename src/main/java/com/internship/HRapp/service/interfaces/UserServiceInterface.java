package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UsersStatusDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {

    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    void assignRole(AssignRoleDTO assignRoleDTO);

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    //UserDTO updateUser(UUID userId, UserDTO userDTO);
    void updateUser (UserCreateDTO userCreateDTO);

    void updateUsersStatus (UsersStatusDTO usersStatusDTO);

    UserDetails loadUserByUsername(String username);
}
