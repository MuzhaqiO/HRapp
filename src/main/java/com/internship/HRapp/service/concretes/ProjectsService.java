package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.projectsDTO.ProjectsDTO;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectsService implements ProjectsServiceInterface {

    private final ProjectsRepo projectsRepo;
    private final UserRepo userRepo;
    private final ProjectsMapper projectsMapper;
    private final UserMapper userMapper;

    @Override
    public List<ProjectsDTO> getProjects() {
        return projectsMapper.entitiesToDtos(projectsRepo.findAll());
    }

    @Override
    public ProjectsDTO getProjectById(UUID projectId) {
        return projectsMapper.entityToDto((projectsRepo.getById(projectId)));
    }

    @Override
    public ProjectsDTO getProjectByProjectName(String projectName) {
        return projectsMapper.entityToDto(projectsRepo.findByProjectsName(projectName));
    }

    @Override
    public List<ProjectsDTO> getProjectsByUserId(UUID userId) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return projectsMapper.entitiesToDtosProjects((projectsRepo.getProjectsByUsersUserId(userId)));
    }

    @Override
    public ProjectsDTO addNewProjects(ProjectsDTO projectsDTO) {
        Projects createdProject = projectsRepo.save(projectsMapper.dtoToEntity(projectsDTO));
        return projectsMapper.entityToDto(createdProject);
    }

    @Override
    public String deleteProject(UUID projectsId) {
        boolean exists = projectsRepo.existsById(projectsId);
        if (!exists){
            throw new IllegalStateException(
                    "Project with id " + projectsId + " does not exist!"
            );
        }
       projectsRepo.deleteById(projectsId);
       return "Project {} was removed"+projectsId;
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
    public AssignUserDTO assignUserToProject(UUID projectId, AssignUserDTO assignUserDTO) {
        Projects project = projectsRepo.getById(projectId);
        project.getUsers().addAll(userMapper.toEntitiesGet(assignUserDTO.getUsers()));
        projectsRepo.save(project);
        return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }
    @Override
    public AssignUserDTO removeUserFromProject(UUID projectId, UUID userId){
        Projects project = projectsRepo.getById(projectId);
        project.getUsers().removeIf(user -> user.getUserId().equals(userId));
        projectsRepo.save(project);
        return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }
}
