package com.internship.HRapp.dto;

import lombok.Data;
import java.time.LocalDate;

@Data


public class createDayOffDTO {
    private String username;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String permissionType;
    private String report;
    private Long dayOffAmount;
}
