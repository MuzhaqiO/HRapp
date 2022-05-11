package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.enumeration.TrustLevel;

import java.time.LocalDate;
import java.util.UUID;

public interface ExperiencesServiceInterface {
    void getExperience(Experiences experiences);

    void addNewExperiences(Experiences experiences);

    void deleteExperiences(UUID expId);

    void updateExperiences(UUID expId, String company, String positions, LocalDate startTime, LocalDate endTime, String description, TrustLevel trustLevel);
}
