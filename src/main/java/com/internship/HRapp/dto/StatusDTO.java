package com.internship.HRapp.dto;

import com.internship.HRapp.enums.DayOffStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class StatusDTO {
    UUID dayOffId;
    DayOffStatus requestStatus;
    UUID idOfApprove;
}
