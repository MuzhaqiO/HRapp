package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.educationDto.EducationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface EducationInterface {


   List<EducationDto> getEducations();
   EducationDto addNewEducation(EducationDto educationDto);
   void editEducation(EducationDto educationDto);
   EducationDto getEducationById(UUID educationId);

   String deleteEducationById(UUID educationId);
}
