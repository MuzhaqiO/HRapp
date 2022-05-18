package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class UserCreateDTO {
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;
    private String mobile;
    private String startingDay;
    private String terminationDay;
    private String secondContact;
    private Boolean usersStatus;
    private Set<RoleDTO> roles;
}
