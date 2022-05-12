package com.internship.HRapp.dto;

import com.internship.HRapp.entity.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class UsersDTO {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Roles> roles;
}
