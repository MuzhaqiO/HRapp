package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.entity.PersonalFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalFileMapper {
    PersonalFileDto modeltoDto(PersonalFile personalFile);
    PersonalFile dtotoModel(PersonalFileDto personalFileDto);
    List<PersonalFileDto> toDto(List<PersonalFile> personalFiles);
    List<PersonalFile> toModel(List<PersonalFileDto> personalFileDtos);
}