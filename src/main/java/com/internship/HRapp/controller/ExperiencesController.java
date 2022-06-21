package com.internship.HRapp.controller;

import com.internship.HRapp.dto.experienceDto.UserExperienceDTO;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/experience")
public class ExperiencesController {


    private final ExperiencesService experiencesService;


    @PostMapping("addExperiences")
    public ResponseEntity<UserExperienceDTO> save(@RequestBody UserExperienceDTO userExperienceDTO){
        return  ResponseEntity.ok(experiencesService.addNewExperiences(userExperienceDTO));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<UserExperienceDTO>>getExperiences(){
        return ResponseEntity.ok(experiencesService.getExperiences());
    }

    @GetMapping("getExperiencesByUserId/{userId}")
    public ResponseEntity<List<UserExperienceDTO>> getExperiencesByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(experiencesService.getExperiencesByUserId(userId));
    }

    @GetMapping("getExperiencesByExpId/{expId}")
    public ResponseEntity<UserExperienceDTO> getExperiencesByExpId(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesService.getExperiencesByExpId(expId));
    }

    @PutMapping("updateExperience/{expId}")
    public void updateExperiences(@RequestBody UserExperienceDTO userExperienceDTO){
        experiencesService.updateExperiences(userExperienceDTO);
    }
    @DeleteMapping("deleteExperience/{expId}")
    public String deleteExperience(@PathVariable UUID expId){
        return experiencesService.deleteExperienceByExpId(expId);

    }


   /* @GetMapping("/experiences/id/{expId}")
    public ResponseEntity<List<UserExperienceDTO>> findExperienceById(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesService.getExperiencesByUserId(expId));
    }*/
/*
    @GetMapping("/experiences/{id}")
    public ResponseEntity<UserExperienceDTO>findById(@PathVariable("id") UUID id){
        return new ResponseEntity(experiencesMapper.entityToDto(experiencesRepo.findById(id).get()),HttpStatus.OK);
    }
    @DeleteMapping("/experiences/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable("id") UUID id){
        UserExperienceDTO userExperienceDTO = experiencesMapper.entityToDto(experiencesRepo.findById(id).get());

        experiencesRepo.deleteById(userExperienceDTO.getUserId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/

 /*   @GetMapping("/users-experience")
    public List<UserExperienceDTO> getAllUsersExperiences(){
        return experiencesService.getAllUsersExperiences();
    }*/

}