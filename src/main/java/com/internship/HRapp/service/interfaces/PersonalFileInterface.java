package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PersonalFileInterface {


    List<PersonalFileDto> getPersonalFiles();
    PersonalFileDto addNewPersonalFile(PersonalFileDto personalFileDto);
    void editPersonalFile(PersonalFileDto personalFileDto);
    PersonalFileDto getPersonalFileById(UUID personalfileId);

    String deletePersonalFileById(UUID personalfileId);
}
