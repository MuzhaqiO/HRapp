package com.internship.HRapp.controller;

import com.internship.HRapp.dto.projectsDTO.ProjectsDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectsUsersDTO;
import com.internship.HRapp.dto.roleDTO.AssignRoleDTO;
import com.internship.HRapp.dto.roleDTO.RemoveRoleDTO;
import com.internship.HRapp.dto.roleDTO.UpdateRoleDTO;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.service.concretes.ProjectsService;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/hr_management_system/projects")
@RequiredArgsConstructor
public class ProjectsController{
    private final ProjectsServiceInterface projectsServiceInterface;

    @PostMapping("addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO){
        return  ResponseEntity.ok(projectsServiceInterface.addNewProjects(projectsDTO));
    }
    @GetMapping("getProjectByUserId/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }
    @GetMapping("getProjectById/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectById(projectsId));
    }
    @GetMapping("getProjectByname/{projectsName}")
    public ResponseEntity<ProjectsDTO> findProjectByName(@PathVariable String projectsName){
        return ResponseEntity.ok(projectsServiceInterface.getProjectByProjectName(projectsName));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<ProjectsDTO>>getProjects(){
        return ResponseEntity.ok(projectsServiceInterface.getProjects());
    }
    @PutMapping("updateProject/{projectId}")
    public void updateProject(@RequestBody ProjectsDTO projectsDTO){
        projectsServiceInterface.updateProject(projectsDTO);
    }
//    @PatchMapping("assignUser/{projectId}")
//    public ResponseEntity<AssignUserDTO> assignUserToProject(@PathVariable UUID projectId, @RequestParam UUID userId){
//        return ResponseEntity.ok(projectsServiceInterface.assignUserToProject(projectId, userId));
//    }
    @PatchMapping("removeUser/{projectId}")
    public ResponseEntity<AssignUserDTO> removeUserFromProject(@PathVariable UUID projectId, @RequestParam UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.removeUserFromProject(projectId, userId));
    }
}
