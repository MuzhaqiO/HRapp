package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")

    private UUID personalFileId;
    private URL id_card;
    private URL degree;
    private String working_skills;

    @ManyToOne
    @JoinColumn(name = "user_personalFile_id", referencedColumnName = "userId")
    private User users;
}
