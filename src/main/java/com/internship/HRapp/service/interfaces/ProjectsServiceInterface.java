package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.projectsDTO.ProjectsDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectsUsersDTO;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {

    List<ProjectsDTO> getProjectsByUserId(UUID userId);
   // void addProjectToNewUser();
    List<ProjectsDTO> getProjects();
    ProjectsDTO getProjectById(UUID projectId);

    ProjectsDTO getProjectByProjectName(String projectName);

    ProjectsDTO addNewProjects(ProjectsDTO projectsDTO);

    String deleteProject(UUID expId);

    void updateProject(ProjectsDTO projectsDTO);

//    AssignUserDTO assignUserToProject(UUID projectId, UUID userId);

    AssignUserDTO removeUserFromProject(UUID projectId, UUID userId);
}
