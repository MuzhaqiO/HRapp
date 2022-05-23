package com.internship.HRapp.dto.dayOffDTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data


public class createDayOffDTO {
    private String username;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String permissionType;
    private String report;
    private Long dayOffAmount;
    private UUID userId;
}
