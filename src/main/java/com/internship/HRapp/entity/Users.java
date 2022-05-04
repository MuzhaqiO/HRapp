package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue( generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;

    @Transient
    private Integer age;
}
