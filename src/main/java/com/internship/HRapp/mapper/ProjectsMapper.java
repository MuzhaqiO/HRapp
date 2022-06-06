package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.projectsDTO.ProjectAssignDTO;
import com.internship.HRapp.dto.projectsDTO.ProjectsDTO;
import com.internship.HRapp.dto.userDTO.AssignUserDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {
   // @Mapping(source = "users.userId", target="userId")
    ProjectsDTO entityToDto(Projects projects);

    List<ProjectsDTO> entitiesToDtos(List<Projects> theProjects);
    List<ProjectsDTO> entitiesToDtosProjects(List<Projects> theProjects);

    //@Mapping(source ="userId", target = "users.userId")
    Projects dtoToEntity(ProjectsDTO projectsDTO);
    List<Projects> toEntities(List<ProjectsDTO> projectsDTOS);

    //ASSIGN USER TO PROJECT MAPPER
 AssignUserDTO toDTOAssignUser (Projects project);
 List<AssignUserDTO> toDTOsAssignUser(List<Projects> projects);
 Projects toEntityAssignUser(AssignUserDTO assignUserDTO);
 List<Projects> toEntitiesAssignUser(List<AssignUserDTO> assignUserDTOs);
}
