package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperiencesMapper {

    ExperiencesMapper INSTANCE = Mappers.getMapper(ExperiencesMapper.class);

    @Mapping(source ="users.userId", target = "userId")
    UserExperienceDTO entityToDto(Experiences experiences);

    List<UserExperienceDTO> entitiesToDtos(List<Experiences> experiences);
    @Mapping(source ="userId", target = "users.userId")

    Experiences dtoToEntity(UserExperienceDTO userExperienceDTO);
}