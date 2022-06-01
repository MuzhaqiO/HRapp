package com.internship.HRapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<User> users = new ArrayList<>();
    /*@OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User users;*/
}
