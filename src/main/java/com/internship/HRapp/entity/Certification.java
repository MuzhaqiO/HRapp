package com.internship.HRapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    @Column(name = "ID")
    @Type(type = "org.hibernate.type.PostgresUUIDType")

    private UUID certificationID;
    private String certification_name;
    private Date certification_year;
    private Date expiration_date;
    private String releasing_authority;
    private String link_of_certification;

    @ManyToOne
    @JoinColumn(name = "user_certification_id", referencedColumnName = "userId")
    private User users;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "userid", nullable = false,
//        referencedColumnName = "userid")
//    private Users users;
}
