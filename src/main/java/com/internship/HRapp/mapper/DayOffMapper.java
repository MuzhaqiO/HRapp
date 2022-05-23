package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.StatusDTO;
import com.internship.HRapp.dto.UserDayOffDTO;
import com.internship.HRapp.dto.createDayOffDTO;
import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DayOffMapper {
    UserDayOffDTO toDto(DayOff dayOff);

    StatusDTO statusToDTO(DayOff dayOff);

    DayOff toModel(UserDayOffDTO userDayOffDTO);

    //@Mapping(target = "users.userId", source = "userId")
    DayOff toEntity(createDayOffDTO requestDTO);

    UserDayOffDTO userToDto(User user);

    User toUser(UserDayOffDTO userDayOffDTO);

    List<UserDayOffDTO> toDtos(List<DayOff> dayOffList);
}