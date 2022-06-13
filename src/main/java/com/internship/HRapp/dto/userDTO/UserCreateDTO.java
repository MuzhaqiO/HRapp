package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class UserCreateDTO {
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private String mobile;
    private LocalDate startingDay;
    private String secondContact;
    private Boolean usersStatus = true;
    private List<RoleDTO> roles;
}
