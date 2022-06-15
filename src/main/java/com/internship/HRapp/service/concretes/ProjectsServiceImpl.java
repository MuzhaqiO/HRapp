package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.dto.projectDTO.ProjectsDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.UserRepo;
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
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    @Override
    public List<ProjectsDTO> getProjectsByUserId(UUID userId) {
        var test = projectsMapper.entitiesToDtosProjects((projectsRepo.getProjectsByUserId(userId)));
        return  test;
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
//    @Override
//    public List<UserDTO> getUsersByProjectId( UUID projectId){
//        return projectsMapper.entityToDto(projectsRepo.ge)
//    }

    @Override
    public ProjectsDTO addNewProjects(ProjectsDTO projectsDTO) {
        Projects createdProject = projectsRepo.save(projectsMapper.dtoToEntity(projectsDTO));
        return projectsMapper.entityToDto(createdProject);
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

//    @Override
//    public AssignUserDTO assignUserToProject(UUID projectId, UUID userId) {
//            Projects project = projectsRepo.getProjectsByProjectId(projectId);
//            project.getUsers().add(userRepo.getById(userId));
//            projectsRepo.save(project);
//            return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }

    @Override
    public AssignUserDTO assignUserToProject(UUID projectId, String username) {
            Projects project = projectsRepo.getProjectsByProjectId(projectId);
            project.getUsers().add(userRepo.getByUsername(username));
            projectsRepo.save(project);
            return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }

    @Override
    public String deleteProjectById(UUID projectId) {
        projectsRepo.deleteById(projectId);
        return "Project {projectId} has been deleted"+ projectId;
    }


    @Override
    public List<ProjectsDTO> getProjects() {
        return projectsMapper.entitiesToDtos(projectsRepo.findAll());
    }
}
