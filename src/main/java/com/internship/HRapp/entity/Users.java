package com.internship.HRapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userId", columnDefinition = "VARCHAR(255)")
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;

    @Transient
    private Integer age;


}
