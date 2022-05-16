package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.UserProjectsDTO;
import com.internship.HRapp.entity.Projects;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {
   // @Mapping(source = "users.userId", target="userId")
    UserProjectsDTO entityToDto(Projects projects);

    List<UserProjectsDTO> entitiesToDtos(List<Projects> theProjects);

    //@Mapping(source ="userId", target = "users.userId")
    Projects dtoToEntity(UserProjectsDTO userProjectsDTO);
}
