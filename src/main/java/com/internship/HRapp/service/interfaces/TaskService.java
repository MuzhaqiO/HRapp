package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDTO addTask(TaskDTO newDTO);

    TaskDTO assignTask(TaskAssignDTO assignDTO);

    void deleteTask(UUID taskId);

    List<TaskDTO> getTasksByUserId(UUID userId);

    List<TaskDTO> getTasksByProjectId(UUID projectId);


}
