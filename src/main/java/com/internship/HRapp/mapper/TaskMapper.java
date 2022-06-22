package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "user.userId", target = "userId")
    TaskAssignDTO taskAssignToDto(Task task);

    @Mapping(source = "userId", target = "user.userId")
    Task taskAssignToEntity(TaskAssignDTO assignDTO);

    @Mapping(source = "project.projectId", target = "projectId")
    @Mapping(source = "user.userId", target = "userId")
    TaskDTO taskToDto(Task task);

    @Mapping(source = "projectId", target = "project.projectId")
    @Mapping(source = "userId", target = "user.userId")
    Task taskToEntity(TaskDTO taskDTO);

    List<TaskDTO> taskListToDto(List<Task> taskList);

}
