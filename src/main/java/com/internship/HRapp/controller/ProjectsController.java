package com.internship.HRapp.controller;

import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/projects")
public class ProjectsController {
    private final ProjectsServiceInterface projectsServiceInterface;

    @PostMapping("addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO){
        return  ResponseEntity.ok(projectsServiceInterface.addNewProjects(projectsDTO));
    }
    @GetMapping("getByUserId/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }
    @GetMapping("getById/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectById(projectsId));
    }
    @GetMapping("getByName/{projectsName}")
    public ResponseEntity<ProjectsDTO> findProjectByName(@PathVariable String projectsName){
        return ResponseEntity.ok(projectsServiceInterface.getProjectByProjectName(projectsName));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<ProjectsDTO>>getAllProjects(){
        return ResponseEntity.ok(projectsServiceInterface.getProjects());
    }
    @PutMapping("updateProject/{projectId}")
    public ResponseEntity<ProjectsDTO> updateProject(@RequestBody ProjectsDTO projectsDTO){
        return ResponseEntity.ok(projectsServiceInterface.updateProject(projectsDTO));
    }
    @PatchMapping("assignUser/{projectId}/userId/{userId}")
    public ResponseEntity<AssignUserDTO> assignUserToProject(@PathVariable UUID projectId, @PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.assignUserToProject(projectId, userId));
    }
    @DeleteMapping("deleteProject/{projectId}")
    public void deleteProject(@PathVariable UUID projectId){
        projectsServiceInterface.deleteProjectById(projectId);
    }
}