package com.internship.HRapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")

    private UUID educationId;
    @Column(nullable = false)
    private String degree;
    private String university_name;
    private String faculty_name;
    private LocalDate start_time;
    private LocalDate end_time;
    private String average;
    private String active_status;

    @ManyToOne
    @JoinColumn(name = "user_education_id", referencedColumnName = "userId")
    private User users;
}
