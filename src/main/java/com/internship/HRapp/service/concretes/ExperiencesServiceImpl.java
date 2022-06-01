package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ExperiencesServiceImpl{
    @Autowired
    private final ExperiencesRepo experiencesRepo;
    @Autowired
    private final ExperiencesMapper experiencesMapper;

    public UserExperienceDTO getExperienceById(UUID expId) {
        boolean exists = experiencesRepo.existsById(expId);
        if (!exists) {
            throw new IllegalStateException(
                    "Experience with id " + expId + " does not exist");
        }
        return experiencesMapper.entityToDto(experiencesRepo.findById(expId).orElse(null));
    }

    public List<UserExperienceDTO> getExperiences() {
        return experiencesMapper.entitiesToDtos(experiencesRepo.findAll());
    }

    /*  public List<UserExperienceDTO> getAllUsersExperiences(){
            return experiencesRepo.findAll()
                    .stream()
                    .map(this::entitiesToDtos)
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

    public UserExperienceDTO addNewExperiences(UserExperienceDTO experiencesDTO) {
        Experiences createdExperience = experiencesRepo.save(experiencesMapper.dtoToEntity(experiencesDTO));
        return experiencesMapper.entityToDto(createdExperience);
    }

  /*
    public String deleteExperiences(UUID expId) { //kontrollo nese ekziston si fillim pastaj te fshihet
        boolean exists = experiencesRepo.existsById(expId);
        if(!exists){
            throw new IllegalStateException("Experience with id {} does not exist"+expId);
        }
        experiencesRepo.deleteById(expId);
            return "Experience {} removed " + expId;

    }*/

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
}
