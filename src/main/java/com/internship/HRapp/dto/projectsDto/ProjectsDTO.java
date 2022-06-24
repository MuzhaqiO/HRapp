package com.internship.HRapp.dto.projectsDto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProjectsDTO {
    private UUID projectId;
    private String projectName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
}
