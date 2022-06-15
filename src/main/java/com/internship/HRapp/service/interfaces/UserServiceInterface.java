package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.projectDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.userDTO.*;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {


    UserCreateDTO getUserById(UUID userId);
    UserCreateDTO getUserProfile(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    //UserDTO updateUser(UUID userId, UserDTO userDTO);
    void updateUser (UserCreateDTO userCreateDTO);
    void updateUserDTO (UserDTO userDTO);

    void updateUsersStatus (UsersStatusDTO usersStatusDTO);
    void updateUserByUsername(UserDTO userDTO);

    ProjectAssignDTO assignProjectToUser(String username, UUID projectId);

    AuthResponseDTO login(UserLoginDTO loginDTO) throws Exception;

    void changePassword(PasswordDTO passwordUpdate);
    List<UserDTO> getUserByProjectId(UUID projectId);
    String deleteUserByUserId(UUID userId);
}
