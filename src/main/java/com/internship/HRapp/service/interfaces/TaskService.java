package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.dto.taskDto.TaskNewDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDTO getTaskById(UUID taskId);
    TaskDTO addTask(TaskDTO taskDTO);
    TaskDTO assignTask(UUID userId, UUID taskId);
    void deleteTask(UUID taskId);
    List<TaskDTO> getTasksByUserId(UUID userId);
    List<TaskDTO> getTasksByProjectId(UUID projectId);

}
