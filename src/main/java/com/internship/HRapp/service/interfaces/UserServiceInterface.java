package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UsersStatusDTO;
import com.internship.HRapp.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {


    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    UserCreateDTO updateUser (UserCreateDTO userCreateDTO);

    UsersStatusDTO updateUsersStatus (UsersStatusDTO usersStatusDTO);

    AssignRoleDTO assignRoleToUser(AssignRoleDTO assignRoleDTO);
}
