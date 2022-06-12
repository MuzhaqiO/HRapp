package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.userDTO.*;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {

    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    void assignRole(AssignRoleDTO assignRoleDTO);

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    void updateUser(UserCreateDTO userCreateDTO);

    void updateUsersStatus(UsersStatusDTO usersStatusDTO);

    AuthResponseDTO login(UserLoginDTO loginDTO) throws Exception;

     void changePassword(PasswordDTO passwordUpdate);
}
