package com.internship.HRapp.entity;

import com.internship.HRapp.enums.DayOffStatus;
import com.internship.HRapp.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue( generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID taskId;
    private String taskName;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus =  TaskStatus.UNASSIGNED;

    @ManyToOne
    private User user;

    @ManyToOne
    private Projects project;


}
