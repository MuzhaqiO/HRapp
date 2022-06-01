package com.internship.HRapp.controller;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.service.concretes.EducationServicelmpl;
import com.internship.HRapp.service.interfaces.EducationInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(path ="api/v1/hr_menagement_system/educations")
public class EducationController {

    private final EducationServicelmpl educationService;

    @GetMapping("getAll")
    public ResponseEntity<List<EducationDto>> findEducations() {
        return ResponseEntity.ok(educationService.getEducations());
    }
    @GetMapping("id/{educationId}")
    public ResponseEntity<EducationDto> findEducationById(@PathVariable UUID educationId){
        return ResponseEntity.ok(educationService.getEducationById(educationId));
    }
    @PostMapping("addNewEducation")
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto){
        return ResponseEntity.ok(educationService.addNewEducation(educationDto));
    }
    @PutMapping("edit/{educationId}")
    public void editEducation(@RequestBody EducationDto educationDto){
        educationService.editEducation(educationDto); }

    @DeleteMapping("delete/{educationId}")
    public String deleteRolesById(@PathVariable UUID educationId) {
        return educationService.deleteEducationById(educationId);
    }
}