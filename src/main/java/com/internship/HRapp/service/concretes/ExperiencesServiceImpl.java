package com.internship.HRapp.service.concretes;

import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.enumeration.TrustLevel;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.interfaces.ExperiencesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExperiencesServiceImpl implements ExperiencesServiceInterface {

    private final ExperiencesRepo experiencesRepo;
    @Override
    public void getExperience(Experiences experiences) {

    }

    @Override
    public void addNewExperiences(Experiences experiences) {

    }

    @Override
    public void deleteExperiences(Long expId) {

    }

    @Override
    public void updateExperiences(Long expId, String company, String positions, LocalDate startTime, LocalDate endTime, String description, TrustLevel trustLevel) {

    }
}
