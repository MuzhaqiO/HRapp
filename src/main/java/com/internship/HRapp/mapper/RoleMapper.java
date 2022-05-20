package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface RoleMapper {
        RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
        RoleDTO toDTO(Role role);
        List<RoleDTO> toDTOs(List<Role> roles);
        Role toEntity(RoleDTO roleDTO);
        List<Role> toEntities(List<RoleDTO> roleDTOs);
}
