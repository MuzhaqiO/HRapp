package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExperiencesServiceImpl implements ExperiencesService {

    private final ExperiencesRepo experiencesRepo;

    private final ExperiencesMapper experiencesMapper;

    @Override
    public Experiences getExperienceById(UUID expId) {
        return experiencesRepo.findById(expId).orElse(null);
    }

    @Override
    public List<UserExperienceDTO> getExperiencesByUserId(UUID userId) {
        return experiencesMapper.entitiesToDtos(experiencesRepo.findByUsersUserId(userId));
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

    @Override
    public Experiences addNewExperiences(UserExperienceDTO experiences) {
        return experiencesRepo.save( experiencesMapper.dtoToEntity(experiences));
    }

    @Override
    public String deleteExperiences(UUID expId) { //kontrollo nese ekziston si fillim pastaj te fshihet
        /*if (experiencesRepo.getById(expId)) {
            experiencesRepo.deleteById(expId);
        }*/
            return "Experience {} removed " + expId;

    }

    @Override
    public Experiences updateExperiences(Experiences experiences) {
        return experiencesRepo.save(experiences);
    }
}
