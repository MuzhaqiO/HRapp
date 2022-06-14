package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;

import java.util.List;
import java.util.UUID;

public interface ExperiencesService {
    Experiences getExperienceById(UUID expId);

   // List<UserExperienceDTO> getExperiences(UUID expId);

    List<UserExperienceDTO> getExperiences();

    UserExperienceDTO addNewExperiences(UserExperienceDTO experienceDTO);

//    UserExperienceDTO getExperienceByName(String experienceName);

   // String deleteExperiences(UUID expId);
   //UserExperienceDTO getExperiencesByUserId(UUID userId);
   List<UserExperienceDTO> getExperiencesByUserId(UUID userId);
   UserExperienceDTO getExperiencesByExpId(UUID expId);

    void updateExperiences(UserExperienceDTO experienceDTO);
    String deleteExperienceByExpId(UUID expId);
}
