package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.taskDTO.TaskAssignDTO;
import com.internship.HRapp.dto.taskDTO.TaskDTO;
import com.internship.HRapp.dto.taskDTO.TaskNewDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDTO addTask(TaskNewDTO newDTO);

    TaskDTO assignTask(TaskAssignDTO assignDTO);

    void deleteTask(UUID taskId);

    List<TaskDTO> getTasksByUserId(UUID userId);

    List<TaskDTO> getTasksByProjectId(UUID projectId);


}
