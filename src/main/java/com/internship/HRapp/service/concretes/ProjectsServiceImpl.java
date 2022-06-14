package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
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
    public List<ProjectsDTO> getProjectsByUserId(UUID userId) {
        var test = projectsMapper.entitiesToDtosProjects((projectsRepo.getProjectsByUserId(userId)));
        return test;
    }

   /* @Override
    public void addProjectToNewUser() {
        User user = new User();
        user.setUsername("adushi");
        user.setPassword("123");
        user.setFirstName("arian");
        user.setLastName("dushi");
        user.setEmail("adushi@gmail.com");

        Projects projects =projectsRepo.findByName();
    }*/

    public ProjectsDTO getProjectById(UUID projectId) {
        return projectsMapper.entityToDto((projectsRepo.getProjectsByProjectId(projectId)));
    }

    @Override
    public ProjectsDTO getProjectByProjectName(String projectName) {
        return projectsMapper.entityToDto(projectsRepo.findByProjectsName(projectName));
    }

    @Override
    public ProjectsDTO addNewProjects(ProjectsDTO projectsDTO) {
        Projects createdProject = projectsRepo.save(projectsMapper.dtoToEntity(projectsDTO));
        return projectsMapper.entityToDto(createdProject);
    }

    @Override
    public String deleteProject(UUID projectsId) {
        projectsRepo.deleteById(projectsId);
        return "Project {} was removed" + projectsId;
    }

    @Override
    public void updateProject(ProjectsDTO projectsDTO) {
        Projects projects = projectsRepo.getProjectsByProjectId(projectsDTO.getProjectId());
        projects.setProjectName(projectsDTO.getProjectName());
        projects.setStartTime(projectsDTO.getStartTime());
        projects.setEndTime(projectsDTO.getEndTime());
        projects.setDescription(projectsDTO.getDescription());
        projectsRepo.save(projects);

    }

    @Override
    public List<ProjectsDTO> getProjects() {
        return projectsMapper.entitiesToDtos(projectsRepo.findAll());
    }
}
