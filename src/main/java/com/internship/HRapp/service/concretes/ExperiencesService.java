package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.experiencesDTO.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.ExperiencesServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ExperiencesService implements ExperiencesServiceInterface {
    private final ExperiencesRepo experiencesRepo;
    private final ExperiencesMapper experiencesMapper;
    private final UserRepo userRepo;

    @Override
    public UserExperienceDTO getExperienceById(UUID expId) {
        boolean exists = experiencesRepo.existsById(expId);
        if (!exists) {
            throw new IllegalStateException(
                    "Experience with id " + expId + " does not exist");
        }
        return experiencesMapper.entityToDto(experiencesRepo.findById(expId).orElse(null));
    }

    @Override
    public List<UserExperienceDTO> getExperiences() {
        return experiencesMapper.entitiesToDtos(experiencesRepo.findAll());
    }

    @Override
    public UserExperienceDTO addNewExperiences(UserExperienceDTO experiencesDTO) {
        Experiences createdExperience = experiencesRepo.save(experiencesMapper.dtoToEntity(experiencesDTO));
        return experiencesMapper.entityToDto(createdExperience);
    }

    @Override
    public void updateExperiences(UserExperienceDTO userExperienceDTO) {
        Experiences experiences = experiencesRepo.getExperiencesByExpId(userExperienceDTO.getExpId());
        experiences.setCompany(userExperienceDTO.getCompany());
        experiences.setPositions(userExperienceDTO.getPositions());
        experiences.setStartTime(userExperienceDTO.getStartTime());
        experiences.setEndTime(userExperienceDTO.getEndTime());
        experiences.setDescription(userExperienceDTO.getDescription());
        experiences.setTrustLevel(userExperienceDTO.getTrustLevel());
        experiencesRepo.save(experiences);
    }

    @Override
    public String deleteExperiencesById(UUID expId) {
        boolean exists = experiencesRepo.existsById(expId);
        if (!exists){
            throw new IllegalStateException(
                    "Experience with id " + expId + " does not exist!"
            );
        }
        experiencesRepo.deleteById(expId);
        return "Experience removed {} " + expId;
}

    @Override
    public List<UserExperienceDTO> getExperienceByUserId(UUID userId) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return experiencesMapper.entitiesToDtos(experiencesRepo.getExperiencesByUsersUserId(userId));
    }
}
