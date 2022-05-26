package com.internship.HRapp.dto.taskDTO;

import com.internship.HRapp.enums.TaskStatus;

import java.util.UUID;

public class TaskDTO {
    private UUID taskId;
    private String taskName;
    private TaskStatus taskStatus;
    private UUID userId;
}
