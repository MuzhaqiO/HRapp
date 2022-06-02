package com.internship.HRapp.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Addresses")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    @Type(type = "org.hibernate.type.PostgresUUIDType")

    private UUID addressID;
    private String state;
    private String city;
    private String street;
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

}