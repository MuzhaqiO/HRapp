package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.taskDTO.TaskAssignDTO;
import com.internship.HRapp.dto.taskDTO.TaskDTO;
import com.internship.HRapp.dto.taskDTO.TaskNewDTO;
import com.internship.HRapp.entity.Task;
import com.internship.HRapp.enums.TaskStatus;
import com.internship.HRapp.mapper.TaskMapper;
import com.internship.HRapp.repository.TaskRepository;
import com.internship.HRapp.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepo;
    private final TaskMapper taskMapper;

    @Override
    public TaskDTO addTask(TaskNewDTO newDTO) {
        Task task = taskRepo.save(taskMapper.newTaskToEntity(newDTO));
        return taskMapper.taskToDto(task);
    }

    @Override
    public TaskDTO assignTask(TaskAssignDTO assignDTO) {
        Task task = taskRepo.findTaskByTaskId(assignDTO.getTaskId());
        if (task.getTaskStatus().equals(TaskStatus.UNASSIGNED)) {
            task.setTaskStatus(TaskStatus.ASSIGNED);
        }
        return taskMapper.taskToDto(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        boolean exists = taskRepo.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException(
                    "task with id " + taskId + " does not exist");
        }
        taskRepo.deleteById(taskId);
    }

    @Override
    public List<TaskDTO> getTasksByUserId(UUID userId) {
        return taskMapper.taskListToDto(taskRepo.getTaskByUserUserId(userId));
    }

    @Override
    public List<TaskDTO> getTasksByProjectId(UUID projectId) {
        return taskMapper.taskListToDto(taskRepo.getTaskByProjectProjectId(projectId));
    }
}
