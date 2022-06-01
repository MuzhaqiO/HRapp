package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.userDTO.*;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDTO(User users);
    List<UserDTO> entitiesToDTOs(List<User> users);
    User DTOtoEntity(UserDTO usersDTO);
    List<User> DTOsToEntities(List<UserDTO> userDTOs);
    UserCreateDTO toDTO(User users);
    List<UserCreateDTO> toDTOs(List<User> users);
    User toEntity(UserCreateDTO userCreateDTO);
    List<User> toEntities(List<UserCreateDTO> userCreateDTOs);

    UsersStatusDTO toDTOStatus(User user);
    List<UsersStatusDTO> toDTOsStatus(List<User> users);
    User toEntityStatus(UsersStatusDTO usersStatusDTO);
    List<User> toEntitiesStatus(List<UsersStatusDTO> usersStatusDTOs);
    AssignRoleDTO toDTOAssign(User user);
    List<AssignRoleDTO> toDTOsAssign(List<User> users);
    User toEntityAssign(AssignRoleDTO assignRoleDTO);
    List<User> toEntitiesAssign(List<AssignRoleDTO> assignRoleDTOs);
    ProjectAssignDTO toDTOProject (User user);
    List<ProjectAssignDTO> toDTOsProject(List<User> users);
    User toEntityProject(ProjectAssignDTO projectAssignDTO);
    List<User> toEntitiesProject(List<ProjectAssignDTO> projectAssignDTOs);
}
