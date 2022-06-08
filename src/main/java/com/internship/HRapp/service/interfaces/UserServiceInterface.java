package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {


    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    //UserDTO updateUser(UUID userId, UserDTO userDTO);
    void updateUser (UserCreateDTO userCreateDTO);

    UserDetails loadUserByUsername(String username);
    void updateUsersStatus (UserCreateDTO userCreateDTO);
    void sendRegistrationEmail(UserCreateDTO userCreateDTO);
//    UserDTO editPassword(UUID Id , PasswordUpdate passwordUpdate);
}
