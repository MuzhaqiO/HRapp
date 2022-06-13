package com.internship.HRapp.controller;

import com.internship.HRapp.dto.experiencesDTO.UserExperienceDTO;
import com.internship.HRapp.service.concretes.ExperiencesService;
import com.internship.HRapp.service.interfaces.ExperiencesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/hr_management_system/experiences")
@RequiredArgsConstructor
public class ExperiencesController {

    private final ExperiencesServiceInterface experiencesServiceInterface;


    @PostMapping("addExperiences")
    public ResponseEntity<UserExperienceDTO> save(@RequestBody UserExperienceDTO userExperienceDTO){
        return  ResponseEntity.ok(experiencesServiceInterface.addNewExperiences(userExperienceDTO));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<UserExperienceDTO>>getExperiences(){
        return ResponseEntity.ok(experiencesServiceInterface.getExperiences());
    }
    @GetMapping("getExperienceById/{expId}")
    public ResponseEntity<UserExperienceDTO> findExperienceById(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesServiceInterface.getExperienceById(expId));
    }
    @PutMapping("updateExperience/{expId}")
    public void updateExperiences(@RequestBody UserExperienceDTO userExperienceDTO){
        experiencesServiceInterface.updateExperiences(userExperienceDTO);
    }
    @DeleteMapping("deleteExperience/{expId}")
    public String deleteExperiencesById(@PathVariable UUID expId){
        return experiencesServiceInterface.deleteExperiencesById(expId);
    }
    @GetMapping("getExperienceByUserId/{userId}")
    public ResponseEntity<List<UserExperienceDTO>> getExperiencesByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(experiencesServiceInterface.getExperienceByUserId(userId));
    }
}
