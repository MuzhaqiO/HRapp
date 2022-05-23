package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.addressDto.AddressDto;
import com.internship.HRapp.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
    public interface AddressMapper {
//        AddressMapper INSRANCE = Mappers.getMapper(AddressMapper.class);
        AddressDto modeltoDto(Address address);
        Address dtotoModel (AddressDto addressDto);
        List<AddressDto> toDto(List<Address> addresses);
    }

