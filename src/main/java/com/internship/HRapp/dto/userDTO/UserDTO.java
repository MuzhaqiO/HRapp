package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.ProjectsDTO;
import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.Role;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Set<RoleDTO> roles;
    private Set<ProjectsDTO> projects;
}
