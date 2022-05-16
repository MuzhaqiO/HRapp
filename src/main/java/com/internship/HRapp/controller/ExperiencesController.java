package com.internship.HRapp.controller;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.concretes.ExperiencesServiceImpl;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ExperiencesController {


    private final ExperiencesService experiencesService;


    @PostMapping("/experiences")
    public ResponseEntity<Experiences> save(@RequestBody UserExperienceDTO userExperienceDTO){
        return  ResponseEntity.ok(experiencesService.addNewExperiences(userExperienceDTO));
    }

    @GetMapping("/experiences/{userId}")
    public ResponseEntity<List<UserExperienceDTO>>getExperiences(@PathVariable UUID userId){
        return ResponseEntity.ok(experiencesService.getExperiencesByUserId(userId));
    }

    @GetMapping("/experiences/id/{expId}")
    public ResponseEntity<List<UserExperienceDTO>> findExperienceById(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesService.getExperiencesByUserId(expId));
    }
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
