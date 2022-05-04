package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.enumeration.TrustLevel;

import java.time.LocalDate;

public interface ExperiencesServiceInterface {
    void getExperience(Experiences experiences);

    void addNewExperiences(Experiences experiences);

    void deleteExperiences(Long expId);

    void updateExperiences(Long expId, String company, String positions, LocalDate startTime, LocalDate endTime, String description, TrustLevel trustLevel);
}
