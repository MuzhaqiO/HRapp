package com.internship.HRapp.dto.dayOffDTO;

import com.internship.HRapp.enums.DayOffPermission;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class createDayOffDTO {
    private UUID userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private DayOffPermission permissionType;
    private String reason;
    private String report;
    private Double dayOffAmount;

}
