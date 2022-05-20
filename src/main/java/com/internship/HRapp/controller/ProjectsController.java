package com.internship.HRapp.controller;

import com.internship.HRapp.dto.ProjectsDTO;
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

    @PostMapping("/addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO){
        return  ResponseEntity.ok(projectsServiceInterface.addNewProjects(projectsDTO));
    }
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }
    @GetMapping("/projects/id/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectById(projectsId));
    }
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectsDTO>>getProjects(){
        return ResponseEntity.ok(projectsServiceInterface.getProjects());
    }
    @PutMapping("/experiences/updateProject/{projectId}")
    public void updateProject(@RequestBody ProjectsDTO projectsDTO){
        projectsServiceInterface.updateProject(projectsDTO);
    }
}
