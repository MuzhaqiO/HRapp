package com.internship.HRapp.dto.userDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
   // private Set<RoleDTO> roles;
 //   private Set<ProjectsDTO> projects;
}
