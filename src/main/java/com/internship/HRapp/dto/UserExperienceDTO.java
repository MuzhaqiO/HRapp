package com.internship.HRapp.dto;

import com.internship.HRapp.enumeration.TrustLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserExperienceDTO {
    private UUID userId;
    private UUID expId;
    private String company;
    private String positions;
    private LocalDate startTime;
    private LocalDate endTime;
    private TrustLevel trustLevel;
}
