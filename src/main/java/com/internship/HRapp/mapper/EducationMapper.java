package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.entity.Education;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    EducationDto modeltoDto(Education education);
    Education dtotoModel(EducationDto educationDto);
    List<EducationDto> toDto(List<Education> educations);
    List<Education> toModel(List<EducationDto> educationDtos);
}