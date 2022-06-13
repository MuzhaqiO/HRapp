package com.internship.HRapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "users_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "projectId"))
    private List<Projects> projects = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Certification> certifications = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<PersonalFile> personalFiles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Education> educations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Experiences> experiences = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<DayOff> daysOff = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_address_id", referencedColumnName = "addressID")
    private Address addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();


    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private Double leaveDaysLeft;
    private String mobile;
    private LocalDate startingDay;
    private LocalDate terminationDay;
    private String secondContact;
    private Boolean usersStatus;
}