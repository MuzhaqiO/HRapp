package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.UsersDTO;
import com.internship.HRapp.entity.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
    UsersDTO entityToDTO(Users users);
    List<UsersDTO> entitysToDTOs(List<Users> users);
    @InheritInverseConfiguration
    Users DTOtoEntity(UsersDTO usersDTO);

}
