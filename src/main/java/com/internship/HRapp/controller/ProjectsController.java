package com.internship.HRapp.controller;

import com.internship.HRapp.dto.ProjectsDTO;
import com.internship.HRapp.service.concretes.ProjectsServiceImpl;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProjectsController {
    private final ProjectsServiceImpl projectsService;

    @PostMapping("/addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO){
        return  ResponseEntity.ok(projectsService.addNewProjects(projectsDTO));
    }
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsService.getProjectsByUserId(userId));
    }
    @GetMapping("/projects/id/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsService.getProjectById(projectsId));
    }
    @GetMapping("name/{projectsName}")
    public ResponseEntity<ProjectsDTO> findProjectByName(@PathVariable String projectsName){
        return ResponseEntity.ok(projectsService.getProjectByProjectName(projectsName));
    }
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectsDTO>>getProjects(){
        return ResponseEntity.ok(projectsService.getProjects());
    }
    @PutMapping("/projects/updateProject/{projectId}")
    public void updateProject(@RequestParam ProjectsDTO projectsDTO){
        projectsService.updateProject(projectsDTO);
    }
}
