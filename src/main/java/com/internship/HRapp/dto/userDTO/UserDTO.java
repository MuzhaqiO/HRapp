package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.projectsDTO.ProjectsDTO;
import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Address;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean usersStatus;
    private List<RoleDTO> roles;
    private List<ProjectsDTO> projects;
}
