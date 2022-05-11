package com.internship.HRapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cglib.proxy.Mixin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID CertificationID;
    private String certification_name;
    private Date certification_year;
    private Date expiration_date;
    private String releasing_authority;
    private URL link_of_certification;

   /* @ManyToOne
    @JoinColumn(name = "certificationId")
    private User user;*/

}
