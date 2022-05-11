package com.internship.HRapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.HashSet;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;

    @OneToMany(mappedBy="users")
    private List<Experiences> experiences;

    @Transient
    private Integer age;


}
