package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.Users;
import com.internship.HRapp.enumeration.TrustLevel;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.interfaces.ExperiencesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperiencesServiceImpl implements ExperiencesServiceInterface {

    @Autowired
    private final ExperiencesRepo experiencesRepo;

   /* public List<UserExperienceDTO> getAllUsersExperiences(){
      return experiencesRepo.findAll()
              .stream()
              .map(this::convertEntityToDTO)
              .collect(Collectors.toList());
    }*/
   /* private UserExperienceDTO convertEntityToDTO(Experiences experiences){
        UserExperienceDTO userExperienceDTO = new UserExperienceDTO();
        userExperienceDTO.setUserId(experiences.getUsers().getUserId());
        userExperienceDTO.setCompany(experiences.getCompany());
        userExperienceDTO.setPositions(experiences.getPositions());
        userExperienceDTO.setStartTime(experiences.getStartTime());
        userExperienceDTO.setEndTime(experiences.getEndTime());
        userExperienceDTO.setTrustLevel(experiences.getTrustLevel());
        return userExperienceDTO;
    }*/
    @Override
    public void getExperience(Experiences experiences) {

    }

    @Override
    public void addNewExperiences(Experiences experiences) {

    }

    @Override
    public void deleteExperiences(UUID expId) {

    }

    @Override
    public void updateExperiences(UUID expId, String company, String positions, LocalDate startTime, LocalDate endTime, String description, TrustLevel trustLevel) {

    }
}
