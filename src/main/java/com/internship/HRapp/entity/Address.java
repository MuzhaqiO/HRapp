package com.internship.HRapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "addressID")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID addressID;
    private String state;
    private String city;
    private String street;
    private String postalCode;
    @OneToOne
    private User users;
}