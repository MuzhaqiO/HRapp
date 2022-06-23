package com.internship.HRapp.dto.dayOffDto;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class UserOffDTO {
    private String firstName;
    private String lastName;
    private Integer leaveDaysLeft;
    private LocalDate startDate;

//    public Integer getLeaveDaysLeft(){
//        return (int) ChronoUnit.DAYS.between(startDate, LocalDate.now());
//    }
}
