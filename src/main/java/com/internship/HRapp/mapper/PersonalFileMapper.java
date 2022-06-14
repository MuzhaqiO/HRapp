package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.personalFileDto.PersonalFileDTO;
import com.internship.HRapp.entity.PersonalFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalFileMapper {
    PersonalFileDTO modeltoDto(PersonalFile personalFile);
    PersonalFile dtotoModel(PersonalFileDTO personalFileDto);
    List<PersonalFileDTO> toDto(List<PersonalFile> personalFiles);
    List<PersonalFile> toModel(List<PersonalFileDTO> personalFileDtos);
}