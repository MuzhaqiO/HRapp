package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.entity.Education;
import com.internship.HRapp.mapper.EducationMapper;
import com.internship.HRapp.repository.EducationRepository;
import com.internship.HRapp.service.interfaces.EducationInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public  class EducationServicelmpl{
    @Autowired
    private final EducationRepository educationRepository;
    @Autowired
    private final EducationMapper educationMapper;

    public EducationDto getEducationById(UUID educationId){
        boolean exists = educationRepository.existsById(educationId);
        if (!exists){
            throw new IllegalStateException(
                    "Education with id " + educationId + " does not exist!"
            );
        }
        return educationMapper.modeltoDto(educationRepository.getById(educationId));
    }

    public List<EducationDto> getEducations(){
        return educationMapper.toDto(educationRepository.findAll());
    }

    public EducationDto addNewEducation(EducationDto educationDto){
        Education createdEducation = educationRepository.save(educationMapper.dtotoModel(educationDto));
        return educationMapper.modeltoDto(createdEducation);
    }

    public String deleteEducationById(UUID educationId){
        boolean exists = educationRepository.existsById(educationId);
        if (!exists){
            throw new IllegalStateException(
                    "Education with id " + educationId + " does not exist!"
            );
        }
        educationRepository.deleteById(educationId);
        return "Education removed {} " + educationId;
    }

    public void editEducation(EducationDto educationDto) {
        Education education =educationRepository.findEducationByEducationId(educationDto.getEducationId());
        education.setDegree(educationDto.getDegree());
        education.setUniversity_name(educationDto.getUniversity_name());
        education.setFaculty_name(educationDto.getFaculty_name());
        education.setStart_time(educationDto.getStart_time());
        educationRepository.save(education);
    }

}
