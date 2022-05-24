package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.entity.PersonalFile;
import com.internship.HRapp.mapper.PersonalFileMapper;
import com.internship.HRapp.repository.PersonalFileRepository;
import com.internship.HRapp.service.interfaces.PersonalFileInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonalFileServicelmpl implements PersonalFileInterface {
    private final PersonalFileRepository personalFileRepository;
    private final PersonalFileMapper personalFileMapper;

    @Override
    public PersonalFileDto getPersonalFileById(UUID personalfileId) {
        return
        personalFileMapper.modeltoDto(personalFileRepository.getById(personalfileId));
    }

    @Override
    public List<PersonalFileDto> getPersonalFiles(){
        return personalFileMapper.toDto(personalFileRepository.findAll());
    }
    @Override
    public String deletePersonalFileById(UUID personalfileId){
        personalFileRepository.deleteById(personalfileId);
        return "personalfile removed {}" + personalfileId;
    }



    @Override
    public PersonalFileDto addNewPersonalFile(PersonalFileDto personalFileDto ) {
        PersonalFile createdPersonalFile = personalFileRepository.save(personalFileMapper.dtotoModel(personalFileDto));
        return personalFileMapper.modeltoDto(createdPersonalFile);
    }

    @Override
    public void  editPersonalFile(@NotNull PersonalFileDto personalFileDto ) {
        PersonalFile personalFile =personalFileRepository.getPersonalFileByPersonalfileId (personalFileDto.getPersonalfileId());
        personalFile.setId_card(personalFileDto.getId_card());
        personalFile.setDegree(personalFileDto.getDegree());
        personalFile.setWorking_skills(personalFileDto.getWorking_skills());
        personalFileRepository.save(personalFile);
    }
}


