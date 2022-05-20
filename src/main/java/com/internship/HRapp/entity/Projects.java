package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID projectId;
    private String projectName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;

    @ManyToMany(mappedBy = "projects")
    private List<User> users = new ArrayList<>();
}
