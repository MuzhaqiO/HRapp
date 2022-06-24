package com.internship.HRapp.controller;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
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
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.addTask(taskDTO));
    }

    @DeleteMapping("deleteTask/{taskId}")
    public void deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
    }

    @PatchMapping("assignUser/{taskId}/userId/{userId}")
    public ResponseEntity<TaskDTO> assignTask(@PathVariable UUID taskId, @PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.assignTask(taskId, userId));
    }

    @GetMapping("getByUserId/{userId}")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @GetMapping("getByProjectId/{projectId}")
    public ResponseEntity<List<TaskDTO>> getTasksByProjectId(@PathVariable UUID projectId) {
        return ResponseEntity.ok(taskService.getTasksByProjectId(projectId));
    }

    @GetMapping("getTaskById/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable UUID taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }
}
