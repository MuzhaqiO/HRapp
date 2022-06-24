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

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public  class EducationServicelmpl implements EducationInterface {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    @Override
    public EducationDto getEducationById(UUID educationId){
        return educationMapper.modeltoDto(educationRepository.getById(educationId));
    }

    @Override
    public List<EducationDto> getEducations(){
        return educationMapper.toDto(educationRepository.findAll());
    }

    @Override
    public EducationDto addNewEducation(EducationDto educationDto){
        Education createdEducation = educationRepository.save(educationMapper.dtotoModel(educationDto));
        return educationMapper.modeltoDto(createdEducation);
    }

    @Override
    public String deleteEducationById(UUID educationId){
        educationRepository.deleteById(educationId);
        return "education removed {}" + educationId;
    }

    @Override
    public void editEducation(EducationDto educationDto) {
        Education education =educationRepository.findEducationByEducationId(educationDto.getEducationId());
        education.setDegree(educationDto.getDegree());
        education.setUniversity_name(educationDto.getUniversity_name());
        education.setFaculty_name(educationDto.getFaculty_name());
        education.setStart_time(educationDto.getStart_time());
        educationRepository.save(education);
    }

}
