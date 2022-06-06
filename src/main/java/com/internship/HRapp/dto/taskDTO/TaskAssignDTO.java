package com.internship.HRapp.dto.taskDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class TaskAssignDTO {
    private UUID taskId;
    private UUID userId;

}