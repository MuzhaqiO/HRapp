package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.entity.Projects;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {
   // @Mapping(source = "users.userId", target="userId")
    ProjectsDTO entityToDto(Projects projects);

    List<ProjectsDTO> entitiesToDtos(List<Projects> theProjects);
    List<ProjectsDTO> entitiesToDtosProjects(List<Projects> theProjects);

    //@Mapping(source ="userId", target = "users.userId")
    Projects dtoToEntity(ProjectsDTO projectsDTO);
}
