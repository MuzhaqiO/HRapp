package com.internship.HRapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Certifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Certification {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "org.hibernate.type.PostgresUUIDType")

    private UUID certificationID;
    @Column(nullable = false)
    private String certification_name;
    private Date certification_year;
    private Date expiration_date;
    private String releasing_authority;
    private String link_of_certification;

    @ManyToOne
    @JoinColumn(name = "user_certification_id", referencedColumnName = "userId")
    private User users;
}