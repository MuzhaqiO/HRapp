package com.internship.HRapp.controller;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.service.concretes.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(path ="api/v1/hr_management_system/educations")
public class EducationController {

    private final EducationService educationService;

    @GetMapping("getAll")
    public ResponseEntity<List<EducationDto>> findEducations() {
        return ResponseEntity.ok(educationService.getEducations());
    }
    @GetMapping("getEducationById/{educationId}")
    public ResponseEntity<EducationDto> findEducationById(@PathVariable UUID educationId){
        return ResponseEntity.ok(educationService.getEducationById(educationId));
    }
    @GetMapping("getEducationByUserId/{userId}")
    public ResponseEntity<List<EducationDto>> getEducationByUser(@PathVariable UUID userId){
        return ResponseEntity.ok(educationService.getEducationByUserId(userId));
    }
    @PostMapping("addNewEducation")
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto){
        return ResponseEntity.ok(educationService.addNewEducation(educationDto));
    }
    @PutMapping("updateEducation/{educationId}")
    public void editEducation(@PathVariable UUID educationId, @RequestBody EducationDto educationDto){
        educationService.editEducation(educationId, educationDto); }

    @DeleteMapping("delete/{educationId}")
    public String deleteRolesById(@PathVariable UUID educationId) {
        return educationService.deleteEducationById(educationId);
    }
}