package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsServiceInterface {

    private final ProjectsRepo projectsRepo;

    private final ProjectsMapper projectsMapper;
    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final UserServiceInterface userService;

    @Override
    public List<ProjectsDTO> getProjectsByUserId(UUID userId) {
        return projectsMapper.entitiesToDtosProjects((projectsRepo.getProjectsByUserId(userId)));
    }

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
    public void deleteProjectById(UUID projectsId) {
        projectsRepo.deleteById(projectsId);
    }

    //    @Override
//    public void updateProject(ProjectsDTO projectsDTO) {
//        Projects projects = projectsRepo.getProjectsByProjectId(projectsDTO.getProjectId());
//        projects.setProjectName(projectsDTO.getProjectName());
//        projects.setStartTime(projectsDTO.getStartTime());
//        projects.setEndTime(projectsDTO.getEndTime());
//        projects.setDescription(projectsDTO.getDescription());
//        projectsRepo.save(projects);
//
//    }
    @Override
    public ProjectsDTO updateProject(ProjectsDTO projectsDTO) {
        Projects projects = projectsMapper.dtoToEntity(projectsDTO);
        projectsRepo.save(projects);
        return projectsMapper.entityToDto(projects);
    }

    @Override
    public AssignUserDTO assignUserToProject(UUID projectId, UUID userId) {
        Projects project = projectsRepo.getById(projectId);
        project.getUsers().add(userMapper.DTOtoEntity(userService.getUserById(userId)));
        projectsRepo.save(project);
        return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }

    @Override
    public List<ProjectsDTO> getProjects() {
        return projectsMapper.entitiesToDtos(projectsRepo.findAll());
    }
}