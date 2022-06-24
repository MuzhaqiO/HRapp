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
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")

    private UUID educationId;
    private String degree;
    private String universityName;
    private String facultyName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String average;
    private String activeStatus;

    @ManyToOne
    @JoinColumn(name = "user_education_id", referencedColumnName = "userId")
    private User users;
}
