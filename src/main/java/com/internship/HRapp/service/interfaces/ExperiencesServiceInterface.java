package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.experiencesDTO.UserExperienceDTO;

import java.util.List;
import java.util.UUID;

public interface ExperiencesServiceInterface {
    UserExperienceDTO getExperienceById(UUID expId);

   // List<UserExperienceDTO> getExperiences(UUID expId);

    List<UserExperienceDTO> getExperiences();

    UserExperienceDTO addNewExperiences(UserExperienceDTO experienceDTO);

//    UserExperienceDTO getExperienceByName(String experienceName);

   // String deleteExperiences(UUID expId);

    void updateExperiences(UserExperienceDTO experienceDTO);

    String deleteExperiencesById(UUID expId);
    List<UserExperienceDTO> getExperienceByUserId(UUID userId);
}
