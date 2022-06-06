package com.internship.HRapp.dto.taskDTO;

import com.internship.HRapp.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class TaskNewDTO {
    private UUID taskId;
    private UUID userId;
    private UUID projectId;
    private String taskName;
    private TaskStatus taskStatus;


}
