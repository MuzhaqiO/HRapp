package com.internship.HRapp.dto.projectsDTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ProjectsDTO {
    private UUID projectId;
    private String projectName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private List<ProjectsUsersDTO> users;
}
