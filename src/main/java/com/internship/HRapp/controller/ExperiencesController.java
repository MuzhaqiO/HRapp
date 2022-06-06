package com.internship.HRapp.controller;

import com.internship.HRapp.dto.experiencesDTO.UserExperienceDTO;
import com.internship.HRapp.service.concretes.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/experiences")
@RequiredArgsConstructor
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
    @GetMapping("getExperienceById/{expId}")
    public ResponseEntity<UserExperienceDTO> findExperienceById(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesService.getExperienceById(expId));
    }
    @PutMapping("updateExperience/{expId}")
    public void updateExperiences(@RequestBody UserExperienceDTO userExperienceDTO){
        experiencesService.updateExperiences(userExperienceDTO);
    }
    @DeleteMapping("deleteExperience/{expId}")
    public String deleteExperiencesById(@PathVariable UUID expId){
        return experiencesService.deleteExperiencesById(expId);
    }
    @GetMapping("getExperienceByUserId/{userId}")
    public ResponseEntity<List<UserExperienceDTO>> getExperiencesByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(experiencesService.getExperienceByUserId(userId));
    }
}
