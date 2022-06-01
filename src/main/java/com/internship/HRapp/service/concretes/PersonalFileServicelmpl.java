package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.entity.PersonalFile;
import com.internship.HRapp.mapper.PersonalFileMapper;
import com.internship.HRapp.repository.PersonalFileRepository;
import com.internship.HRapp.service.interfaces.PersonalFileInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PersonalFileServicelmpl{
    @Autowired
    private final PersonalFileRepository personalFileRepository;
    @Autowired
    private final PersonalFileMapper personalFileMapper;

    public PersonalFileDto getPersonalFileById(UUID personalfileId) {
        boolean exists = personalFileRepository.existsById(personalfileId);
        if (!exists) {
            throw new IllegalStateException(
                    "Personal file with id " + personalfileId + " does not exist");
        }
        return personalFileMapper.modeltoDto(personalFileRepository.getById(personalfileId));
    }

    public List<PersonalFileDto> getPersonalFiles(){
        return personalFileMapper.toDto(personalFileRepository.findAll());
    }
    public String deletePersonalFileById(UUID personalfileId){
        personalFileRepository.deleteById(personalfileId);
        return "Personal file removed {} " + personalfileId;
    }



    public PersonalFileDto addNewPersonalFile(PersonalFileDto personalFileDto ) {
        PersonalFile createdPersonalFile = personalFileRepository.save(personalFileMapper.dtotoModel(personalFileDto));
        return personalFileMapper.modeltoDto(createdPersonalFile);
    }

    public void  editPersonalFile(@NotNull PersonalFileDto personalFileDto ) {
        PersonalFile personalFile =personalFileRepository.getPersonalFileByPersonalfileId (personalFileDto.getPersonalfileId());
        personalFile.setId_card(personalFileDto.getId_card());
        personalFile.setDegree(personalFileDto.getDegree());
        personalFile.setWorking_skills(personalFileDto.getWorking_skills());
        personalFileRepository.save(personalFile);
    }
}


