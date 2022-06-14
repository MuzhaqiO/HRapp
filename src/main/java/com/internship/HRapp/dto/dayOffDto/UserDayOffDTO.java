package com.internship.HRapp.dto.dayOffDto;

import com.internship.HRapp.enums.DayOffStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDayOffDTO {
    private UUID dayOffId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double dayOffAmount;
    private DayOffStatus requestStatus;
    private UserOffDTO users;
}
