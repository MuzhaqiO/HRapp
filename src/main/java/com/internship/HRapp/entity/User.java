package com.internship.HRapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "users_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "projectsId"))
    private Set<Role> projects = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<Certification> certifications = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<PersonalFile> personalFiles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<Education> educations = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<Experiences> experiences = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<DayOff> daysOff = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_address_id", referencedColumnName = "ID")
    private Address address;


    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate DOB;
    private Double leaveDaysLeft;
    private String mobile;
    private LocalDate startingDay;
    private LocalDate terminationDay;
    private String secondContact;
    private Boolean usersStatus;
}