package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID projectId;
    private String projectName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;

//    @ManyToMany(mappedBy = "projects")
//    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "user_projects", joinColumns = {@JoinColumn(name = "project_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false)})
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
