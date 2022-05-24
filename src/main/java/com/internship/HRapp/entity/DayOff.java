package com.internship.HRapp.entity;

import com.internship.HRapp.enums.DayOffReason;
import com.internship.HRapp.enums.DayOffStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static java.util.concurrent.TimeUnit.DAYS;

@Getter
@Setter
@Entity
@Table
public class DayOff {

    @Id
    @GeneratedValue( generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID dayOffId;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private DayOffReason reason =  DayOffReason.DEFAULT;
    private String permissionType;
    private String report;
    @Enumerated(EnumType.STRING)
    private DayOffStatus requestStatus =  DayOffStatus.PENDING;
    private String rejectReason;
    private UUID idOfApprove;
    @Transient
    private Double dayOffAmount;
    public Double getDayOffAmount(){
        return (double)ChronoUnit.DAYS.between(startDate, endDate);
    }

    @ManyToOne//(fetch = FetchType.EAGER,optional = false)
//    @JoinColumn(name = "user_dayOff_id")
    private User users;




}

