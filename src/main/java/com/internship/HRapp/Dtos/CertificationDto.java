package com.internship.HRapp.Dtos;

import lombok.Data;
import org.apache.tomcat.jni.User;

import java.util.Date;
import java.util.UUID;

@Data
public class CertificationDto {
    private UUID certificationId;
    private String certification_name;
    private Date certification_year;
    private Date expiration_year;
    private String realising_authority;
    private User user;
}
