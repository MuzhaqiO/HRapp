package com.internship.HRapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter

public class PersonalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")

    private UUID personalfileId;
    private URL id_card;
    private URL degree;
    private String working_skills;

    @ManyToOne
    @JoinColumn(name = "user_personalfile_id", referencedColumnName = "userId")
    private User users;
}
