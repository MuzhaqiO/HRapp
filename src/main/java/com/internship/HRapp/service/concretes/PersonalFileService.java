package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.personalfileDto.PersonalFileDto;
import com.internship.HRapp.entity.PersonalFile;
import com.internship.HRapp.mapper.PersonalFileMapper;
import com.internship.HRapp.repository.PersonalFileRepository;
import com.internship.HRapp.repository.UserRepo;
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
@RequiredArgsConstructor
public class PersonalFileService implements PersonalFileInterface {
    private final PersonalFileRepository personalFileRepository;
    private final PersonalFileMapper personalFileMapper;
    private final UserRepo userRepo;

    @Override
    public PersonalFileDto getPersonalFileById(UUID personalFileId) {
        boolean exists = personalFileRepository.existsById(personalFileId);
        if (!exists) {
            throw new IllegalStateException(
                    "Personal file with id " + personalFileId + " does not exist");
        }
        return personalFileMapper.modeltoDto(personalFileRepository.getById(personalFileId));
    }

    @Override
    public List<PersonalFileDto> getPersonalFiles(){
        return personalFileMapper.toDto(personalFileRepository.findAll());
    }
    public String deletePersonalFileById(UUID personalFileId){
        personalFileRepository.deleteById(personalFileId);
        return "Personal file removed {} " + personalFileId;
    }

    @Override
    public List<PersonalFileDto> getPersonalFileByUserId(UUID userId) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return personalFileMapper.toDto(personalFileRepository.getPersonalFileByUsersUserId(userId));
    }

    @Override
    public PersonalFileDto addNewPersonalFile(PersonalFileDto personalFileDto ) {
        PersonalFile createdPersonalFile = personalFileRepository.save(personalFileMapper.dtotoModel(personalFileDto));
        return personalFileMapper.modeltoDto(createdPersonalFile);
    }

    @Override
    public PersonalFileDto editPersonalFile(PersonalFileDto personalFileDto ) {
        PersonalFile updatedPersonalFile = personalFileRepository.save(personalFileMapper.dtotoModel(personalFileDto));
        return personalFileMapper.modeltoDto(updatedPersonalFile);
    }
}


