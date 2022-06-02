package com.internship.HRapp.dto.dayOffDTO;

import com.internship.HRapp.enums.DayOffStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StatusDTO {
    private UUID dayOffId;
    private DayOffStatus requestStatus;
    private UUID userId;
    private String rejectReason;
}
