package com.internship.HRapp.entity;

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

    @OneToMany(mappedBy = "user")
    private List<Certification> certifications = new ArrayList<>();

    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;
    private String mobile;
    private String startingDay;
    private String terminationDay;
    private String secondContact;
    private Boolean usersStatus;
}
