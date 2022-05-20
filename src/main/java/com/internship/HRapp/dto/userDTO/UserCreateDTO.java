package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.ProjectsDTO;
import com.internship.HRapp.dto.roleDTO.RoleDTO;
import lombok.Data;

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
    private Set<RoleDTO> roles;
    private Set<ProjectsDTO> projects;
}
