package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.dayOffDTO.UserOffDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.dto.userDTO.UserLoginDTO;
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
    List<UserCreateDTO> oDTOs(List<User> users);
    User toEntity(UserCreateDTO userCreateDTO);
    List<User> toEntities(List<UserCreateDTO> userCreateDTOs);
    User userLoginToDto(UserLoginDTO userLoginDTO);
    UserLoginDTO userLoginToEntity(User user);
    UserOffDTO offToUser(User user);
}
