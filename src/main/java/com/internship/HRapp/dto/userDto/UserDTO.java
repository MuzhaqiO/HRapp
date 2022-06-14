package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.roleDto.RoleDTO;
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
