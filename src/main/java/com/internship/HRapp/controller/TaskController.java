package com.internship.HRapp.controller;

import com.internship.HRapp.dto.taskDTO.TaskAssignDTO;
import com.internship.HRapp.dto.taskDTO.TaskDTO;
import com.internship.HRapp.dto.taskDTO.TaskNewDTO;
import com.internship.HRapp.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("newTask")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskNewDTO newDTO) {
        return ResponseEntity.ok(taskService.addTask(newDTO));

    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") UUID taskId) {
        taskService.deleteTask(taskId);

    }

    @PatchMapping("assignTask")
    public ResponseEntity<TaskDTO> assignTask(@RequestBody TaskAssignDTO assignDTO) {
        return ResponseEntity.ok(taskService.assignTask(assignDTO));

    }
    @GetMapping("userId")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@RequestParam UUID userId){
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }
    @GetMapping("projectId")
    public ResponseEntity<List<TaskDTO>> getTasksByProjectId(@RequestParam UUID projectId){
        return ResponseEntity.ok(taskService.getTasksByProjectId(projectId));
}}
