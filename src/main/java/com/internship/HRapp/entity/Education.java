package com.internship.HRapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table
@Getter
@Setter

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")

    private UUID educationId;
    private String degree;
    private String university_name;
    private String faculty_name;
    private LocalDate start_time;
    private LocalDate end_time;
    private String average;
    private String active_status;
    private UUID userId;

@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name = "educationId")
private User user;
}
