package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;

import java.util.List;
import java.util.UUID;

public interface ExperiencesService {
    Experiences getExperienceById(UUID expId);

    List<UserExperienceDTO> getExperiencesByUserId(UUID userId);

   // List<UserExperienceDTO> getExperiences(UUID expId);

    Experiences addNewExperiences(UserExperienceDTO experiences);

//    UserExperienceDTO getExperienceByName(String experienceName);

    String deleteExperiences(UUID expId);

    Experiences updateExperiences(Experiences experiences);
}
