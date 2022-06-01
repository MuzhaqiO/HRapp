package com.internship.HRapp.Dtos;

import lombok.Data;
import org.apache.tomcat.jni.User;

import java.util.UUID;

@Data
public class AddressDto {
    private UUID addressID;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private User user;
}
