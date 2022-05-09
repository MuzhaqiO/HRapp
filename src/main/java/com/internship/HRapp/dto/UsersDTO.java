package com.internship.HRapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
public class UsersDTO {
    @Id
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
