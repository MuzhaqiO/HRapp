package com.internship.HRapp.dto.dayOffDTO;

import lombok.Data;
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
    private UserOffDTO users;
}
