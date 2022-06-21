package com.internship.HRapp.controller;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.dto.taskDto.TaskNewDTO;
import com.internship.HRapp.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("addNewTask")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskNewDTO newDTO) {
        return ResponseEntity.ok(taskService.addTask(newDTO));

    }

    @DeleteMapping("deleteTask/{taskId}")
    public void deleteTask(@PathVariable("taskId") UUID taskId) {
        taskService.deleteTask(taskId);

    }

    @PatchMapping("assignTask")
    public ResponseEntity<TaskDTO> assignTask(@RequestBody TaskAssignDTO assignDTO) {
        return ResponseEntity.ok(taskService.assignTask(assignDTO));

    }

    @GetMapping("getByUserId")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @GetMapping("getByProjectId")
    public ResponseEntity<List<TaskDTO>> getTasksByProjectId(@RequestParam UUID projectId) {
        return ResponseEntity.ok(taskService.getTasksByProjectId(projectId));
    }
}
