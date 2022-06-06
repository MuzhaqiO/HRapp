package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.certificationDto.AssignCertificationDTO;
import com.internship.HRapp.dto.educationDto.AssignEducationDTO;
import com.internship.HRapp.dto.experiencesDTO.AssignExperiencesDTO;
import com.internship.HRapp.dto.personalfileDto.AssignPersonalFileDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.roleDTO.RemoveRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateRoleDTO;
import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDTO(User users);
    List<UserDTO> entitiesToDTOs(List<User> users);
    User DTOtoEntity(UserDTO usersDTO);
    List<User> DTOsToEntities(List<UserDTO> userDTOs);

    //GET USERDTO MAPPER
    GetUsersDTO toDTOGet(User user);
    List<GetUsersDTO> toDTOsGet(List<User> users);
    User toEntityGet(GetUsersDTO getUsersDTO);
    List<User> toEntitiesGet(List<GetUsersDTO> getUsersDTOs);

    // CREATE USER MAPPER
    UserCreateDTO toDTO(User users);
    List<UserCreateDTO> toDTOs(List<User> users);
    User toEntity(UserCreateDTO userCreateDTO);
    List<User> toEntities(List<UserCreateDTO> userCreateDTOs);

    //UPDATE USER MAPPER
    UserUpdateDTO toDTOUpdate(User users);
    List<UserUpdateDTO> toDTOsUpdate(List<User> users);
    User toEntityUpdate(UserUpdateDTO userUpdateDTO);
    List<User> toEntitiesUpdate(List<UserUpdateDTO> userUpdateDTOs);

    //UPDATE PASSWORD MAPPER
    PasswordDTO toDTOPassword(User users);
    List<PasswordDTO> toDTOsPassword(List<User> users);
    User toEntityPassword(PasswordDTO passwordDTO);
    List<User> toEntitiesPassword(List<PasswordDTO> passwordDTOs);

    //UPDATE USERNAME MAPPER
    UsernameDTO toDTOUsername(User users);
    List<UsernameDTO> toDTOsUsername(List<User> users);
    User toEntityUsername(UsernameDTO usernameDTO);
    List<User> toEntitiesUsername(List<UsernameDTO> usernameDTOs);

    //UPDATE USER STATUS MAPPER
    UsersStatusDTO toDTOStatus(User user);
    List<UsersStatusDTO> toDTOsStatus(List<User> users);
    User toEntityStatus(UsersStatusDTO usersStatusDTO);
    List<User> toEntitiesStatus(List<UsersStatusDTO> usersStatusDTOs);

    //ASSIGN ROLE TO USER MAPPER
    AssignRoleDTO toDTOAssign(User user);
    List<AssignRoleDTO> toDTOsAssign(List<User> users);
    User toEntityAssign(AssignRoleDTO assignRoleDTO);
    List<User> toEntitiesAssign(List<AssignRoleDTO> assignRoleDTOs);

    //ASSIGN PROJECT TO USER MAPPER
    ProjectAssignDTO toDTOProject (User user);
    List<ProjectAssignDTO> toDTOsProject(List<User> users);
    User toEntityProject(ProjectAssignDTO projectAssignDTO);
    List<User> toEntitiesProject(List<ProjectAssignDTO> projectAssignDTOs);

    //ASSIGN PERSONAL FILE TO USER MAPPER
    AssignPersonalFileDTO toDTOPersonalFile (User user);
    List<AssignPersonalFileDTO> toDTOsPersonalFile(List<User> users);
    User toEntityPersonalFile(AssignPersonalFileDTO assignPersonalFileDTO);
    List<User> toEntitiesPersonalFile(List<AssignPersonalFileDTO> assignPersonalFileDTOs);

    //ASSIGN EXPERIENCE TO USER MAPPER
    AssignExperiencesDTO toDTOExperience (User user);
    List<AssignExperiencesDTO> toDTOsExperience(List<User> users);
    User toEntityExperience(AssignExperiencesDTO assignExperiencesDTO);
    List<User> toEntitiesExperience(List<AssignExperiencesDTO> assignExperiencesDTOs);

    //ASSIGN EDUCATION TO USER MAPPER
    AssignEducationDTO toDTOEducation (User user);
    List<AssignEducationDTO> toDTOsEducation(List<User> users);
    User toEntityEducation(AssignEducationDTO assignEducationDTO);
    List<User> toEntitiesEducation(List<AssignEducationDTO> assignEducationDTOs);

    //ASSIGN CERTIFICATION TO USER DTO
    AssignCertificationDTO toDTOCertification (User user);
    List<AssignCertificationDTO> toDTOsCertification(List<User> users);
    User toEntityCertification(AssignCertificationDTO assignCertificationDTO);
    List<User> toEntitiesCertification(List<AssignCertificationDTO> assignCertificationDTOs);
    //UPDATE USER ROLE MAPPER
    UpdateRoleDTO toDTORole (User user);
    List<UpdateRoleDTO> toDTOsRole(List<User> users);
    User toEntityRole(UpdateRoleDTO updateRoleDTO);
    List<User> toEntitiesRole(List<UpdateRoleDTO> updateRoleDTOs);

    //REMOVE ROLE FROM USER MAPPER
    RemoveRoleDTO toDTORemove(User user);
    User toEntityRemove (RemoveRoleDTO removeRoleDTO);


}
