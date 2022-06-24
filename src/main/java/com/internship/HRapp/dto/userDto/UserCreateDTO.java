package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
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
    private Integer leaveDaysLeft;
    private String mobile;
    private LocalDate startingDay;
    private LocalDate terminationDay;
    private String secondContact;
    private Boolean usersStatus = true;
    private List<RoleDTO> roles;

}
