package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;
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



    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();


    @ManyToMany(mappedBy = "users")
    private List<Projects> projects = new ArrayList<>();

    @OneToMany(mappedBy="users")
    private List<Experiences> experiences;

    @OneToMany(mappedBy = "users")
    private List<Certification> certifications = new ArrayList<>();
//    @OneToOne(mappedBy = "users")
//    private Address addresses;

    @OneToMany(mappedBy = "users")
    private List<DayOff> daysOff = new ArrayList<>();
}
