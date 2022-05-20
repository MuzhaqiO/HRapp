package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.ProjectsDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {

    List<ProjectsDTO> getProjectsByUserId(UUID userId);
   // void addProjectToNewUser();
    List<ProjectsDTO> getProjects();
    ProjectsDTO getProjectById(UUID projectId);


    // List<UserProjectsDTO> getProjects(UUID expId);

    ProjectsDTO addNewProjects(ProjectsDTO projectsDTO);

    String deleteProject(UUID expId);

    void updateProject(ProjectsDTO projectsDTO);
}
