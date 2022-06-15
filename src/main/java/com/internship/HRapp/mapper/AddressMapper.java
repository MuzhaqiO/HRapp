package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.addressDto.UserAddressDTO;
import com.internship.HRapp.entity.Address;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    //        AddressMapper INSRANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(source ="users.userId", target = "userId")
    UserAddressDTO modeltoDto(Address address);
    @Mapping(source ="userId", target = "users.userId")
    Address dtotoModel (UserAddressDTO addressDto);
    List<UserAddressDTO> toDto(List<Address> addresses);
}
