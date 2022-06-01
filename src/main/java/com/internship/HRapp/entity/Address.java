package com.internship.HRapp.entity;
import lombok.*;
import org.apache.tomcat.jni.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "BINARY(16),updatable=false,nullable=false")

    private UUID AddressID;
    private String state;
    private String city;
    private String street;
    private String postalCode;

    /* @OneToOne(mappedBy = "address")
    private User user;*/
}
