package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {


    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    UserDTO addNewUsers(UserDTO userDTO);
}
