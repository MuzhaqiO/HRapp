package com.internship.HRapp.dto.certificationDto;

import lombok.Data;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Data
public class CertificationDto {
    private UUID certificationID;
    private String certification_name;
    private Date certification_year;
    private Date expiration_date;
    private String releasing_authority;
    private String link_of_certification;
}
