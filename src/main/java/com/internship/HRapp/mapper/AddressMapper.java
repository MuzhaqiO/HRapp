package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.entity.Projects;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
    public interface AddressMapper {
//        AddressMapper INSRANCE = Mappers.getMapper(AddressMapper.class);
        AddressDto modeltoDto(Address address);
        Address dtotoModel (AddressDto addressDto);
        List<AddressDto> toDto(List<Address> addresses);
        List<Address> toModel(List<AddressDto> addressDtos);
    AssignUserDTO toDTOAssignUser (Address address);
    List<AssignUserDTO> toDTOsAssignUser(List<Address> addresses);
    Address toEntityAssignUser(AssignUserDTO assignUserDTO);
    List<Address> toEntitiesAssignUser(List<AssignUserDTO> assignUserDTOs);
    }

