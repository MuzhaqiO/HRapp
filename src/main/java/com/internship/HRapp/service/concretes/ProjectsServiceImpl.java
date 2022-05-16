package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.UserProjectsDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsServiceInterface {

    private final ProjectsRepo projectsRepo;

    private final ProjectsMapper projectsMapper;

    @Override
    public Projects getProjectsById(UUID projectsId) {
        return projectsRepo.findById(projectsId).orElse(null);
    }

    @Override
    public List<UserProjectsDTO> getProjectsByUserId(UUID userId) {
        return projectsMapper.entitiesToDtos((projectsRepo.findByUserId(userId)));
    }

    @Override
    public Projects addNewProjects(UserProjectsDTO projects) {

        return projectsRepo.save(projectsMapper.dtoToEntity(projects));
    }

    @Override
    public String deleteProject(UUID projectsId) {
       projectsRepo.deleteById(projectsId);
       return "Project {} was removed"+projectsId;
    }

    @Override
    public Projects updateProject(Projects projects) {
        return projectsRepo.save(projects);
    }
}
