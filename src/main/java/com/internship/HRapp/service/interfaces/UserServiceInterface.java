package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.certificationDto.AssignCertificationDTO;
import com.internship.HRapp.dto.educationDto.AssignEducationDTO;
import com.internship.HRapp.dto.experiencesDTO.AssignExperiencesDTO;
import com.internship.HRapp.dto.personalfileDto.AssignPersonalFileDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.roleDTO.RemoveRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateUsersRoleDto;
import com.internship.HRapp.dto.userDTO.*;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {


    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getUsers();

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO);

    UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO);

    UsersStatusDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO);
    UsernameDTO updateUsername(UUID userId, UsernameDTO usernameDTO);
    PasswordDTO updatePassword(UUID userId, PasswordDTO passwordDTO);
    AssignRoleDTO assignRoleToUser(UUID userId, AssignRoleDTO assignRoleDTO);
    UpdateRoleDTO removeRoleFromUser(UUID userId, UUID roleId);
    AssignPersonalFileDTO assignPersonalFileToUser(UUID userId, AssignPersonalFileDTO assignPersonalFileDTO);
    AssignPersonalFileDTO removePersonalFileFromUser(UUID userId, UUID personalFileId);
//    UpdateRoleDTO updateRole2(UUID userId, UpdateRoleDTO updateRoleDTO);
    ProjectAssignDTO assignProjectToUser(UUID userId, ProjectAssignDTO projectAssignDTO);

    AssignExperiencesDTO assignExperienceToUser(UUID userId, AssignExperiencesDTO assignExperiencesDTO);

    ProjectAssignDTO removeProjectFromUser(UUID userId, UUID projectId);

    AssignExperiencesDTO removeExperienceFromUser(UUID userId, UUID expId);

    AssignEducationDTO assignEducationToUser(UUID userId, AssignEducationDTO assignEducationDTO);

    AssignEducationDTO removeEducationFromUser(UUID userId, UUID educationId);

    AssignCertificationDTO assignCertificationToUser(UUID userId, AssignCertificationDTO assignCertificationDTO);

    AssignCertificationDTO removeCertificationFromUser(UUID userId, UUID certificationID);

    Boolean updateRole(UpdateUsersRoleDto usersRoleDto);
    List<UserDTO> getUserByRoleId(UUID roleId);
    List<UserDTO> getUserByProjectId(UUID projectId);

}
