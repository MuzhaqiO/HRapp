package com.internship.HRapp.dto.dayOffDTO;

import com.internship.HRapp.enums.DayOffReason;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data


public class createDayOffDTO {
    private UUID userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private DayOffReason reason;
    private String permissionType;
    private String report;

}
