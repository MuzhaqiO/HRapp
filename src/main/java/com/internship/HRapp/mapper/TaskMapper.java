package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.dto.taskDto.TaskNewDTO;
import com.internship.HRapp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskNewDTO newTaskToDto(Task task);

    @Mapping(target = "project.projectId", source = "projectId")
    @Mapping(target = "user.userId", source = "userId")
    Task newTaskToEntity(TaskNewDTO newDTO);

    TaskAssignDTO taskAssignToDto(Task task);

    @Mapping(target = "user.userId", source = "userId")
    Task taskAssignToEntity(TaskAssignDTO assignDTO);

    TaskDTO taskToDto(Task task);

    @Mapping(target = "project.projectId", source = "projectId")
    @Mapping(target = "user.userId", source = "userId")
    Task taskToEntity(TaskDTO taskDTO);

    List<TaskDTO> taskListToDto(List<Task> taskList);

}
