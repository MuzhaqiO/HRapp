package com.internship.HRapp.controller;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.concretes.ExperiencesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExperiencesController {

    private ExperiencesMapper experiencesMapper;

    private ExperiencesServiceImpl experiencesService;

    private ExperiencesRepo experiencesRepo;

    @PostMapping("/experiences")
    public ResponseEntity<Experiences> save(@RequestBody UserExperienceDTO userExperienceDTO){
        return new ResponseEntity<>(experiencesRepo.save(
                experiencesMapper.dtoToEntity(userExperienceDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<UserExperienceDTO>>findAll(){
        return new ResponseEntity<>(experiencesMapper.entitiesToDtos(experiencesRepo.findAll()),HttpStatus.OK);
    }
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

 /*   @GetMapping("/users-experience")
    public List<UserExperienceDTO> getAllUsersExperiences(){
        return experiencesService.getAllUsersExperiences();
    }*/

}
