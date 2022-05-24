package com.internship.HRapp.dto.addressDto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {
    private UUID addressID;
    private String state;
    private String city;
    private String street;
    private String postalCode;
}
