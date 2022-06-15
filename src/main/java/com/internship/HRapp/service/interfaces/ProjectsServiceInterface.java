package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.dto.projectDTO.ProjectsDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {

    List<ProjectsDTO> getProjectsByUserId(UUID userId);
   // void addProjectToNewUser();
    List<ProjectsDTO> getProjects();
    ProjectsDTO getProjectById(UUID projectId);

    ProjectsDTO getProjectByProjectName(String projectName);


    // List<UserProjectsDTO> getProjects(UUID expId);

    ProjectsDTO addNewProjects(ProjectsDTO projectsDTO);


    ProjectsDTO updateProject(ProjectsDTO projectsDTO);

    AssignUserDTO assignUserToProject(UUID projectId, String username);
    String deleteProjectById(UUID projectId);

    //List<UserDTO> getUsersByProjectId(UUID projectId);
}
