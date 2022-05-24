package com.internship.HRapp.dto.educationDto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter

public class EducationDto {
    private UUID userId;
    private UUID educationId;
    private String degree;
    private String university_name;
    private String faculty_name;
    private LocalDate start_time;
    private LocalDate end_time;
    private String average;
    private String active_status;
}