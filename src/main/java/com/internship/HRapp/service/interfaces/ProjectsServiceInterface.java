package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.dto.projectsDto.ProjectsDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {

    List<ProjectsDTO> getProjectsByUserId(UUID userId);
    List<ProjectsDTO> getProjects();
    ProjectsDTO getProjectById(UUID projectId);

    ProjectsDTO getProjectByProjectName(String projectName);

    ProjectsDTO addNewProjects(ProjectsDTO projectsDTO);

    void deleteProjectById(UUID projectId);

    ProjectsDTO updateProject(ProjectsDTO projectsDTO);

    AssignUserDTO assignUserToProject(UUID projectId, UUID userId);
    AssignUserDTO removeUserFromProject(UUID projectId, UUID userId);

}