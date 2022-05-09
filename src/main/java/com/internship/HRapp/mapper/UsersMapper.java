package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.UsersDTO;
import com.internship.HRapp.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
    UsersDTO entityToDTO(Users users);
    Users DTOtoEntity(UsersDTO usersDTO);
}
