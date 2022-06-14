package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.dto.projectsDto.ProjectsDTO;

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

    String deleteProject(UUID expId);

    ProjectsDTO updateProject(ProjectsDTO projectsDTO);

    AssignUserDTO assignUserToProject(UUID projectId, UUID userId);

}