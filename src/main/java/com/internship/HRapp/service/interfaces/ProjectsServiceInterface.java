package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.UserProjectsDTO;
import com.internship.HRapp.entity.Projects;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {
    Projects getProjectsById(UUID expId);

    List<UserProjectsDTO> getProjectsByUserId(UUID userId);

    // List<UserProjectsDTO> getProjects(UUID expId);

    Projects addNewProjects(UserProjectsDTO projects);

    String deleteProject(UUID expId);

    Projects updateProject(Projects projects);
}
