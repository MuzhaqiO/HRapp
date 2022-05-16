package com.internship.HRapp.controller;

import com.internship.HRapp.dto.UserExperienceDTO;
import com.internship.HRapp.dto.UserProjectsDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProjectsController {
    private final ProjectsServiceInterface projectsServiceInterface;

    @PostMapping("/projects")
    public ResponseEntity<Projects> save(@RequestBody UserProjectsDTO userProjectsDTO){
        return  ResponseEntity.ok(projectsServiceInterface.addNewProjects(userProjectsDTO));
    }
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<UserProjectsDTO>> getProjects(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }
    @GetMapping("/projects/id/{projectsId}")
    public ResponseEntity<List<UserProjectsDTO>> findProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(projectsId));
    }
}
