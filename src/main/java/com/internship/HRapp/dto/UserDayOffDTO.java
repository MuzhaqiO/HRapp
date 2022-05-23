package com.internship.HRapp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserDayOffDTO {
    private UUID dayOffId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double dayOffAmount;
    private UserOffDTO users;
}
