package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
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
    private String mobile;
    private Set<RoleDTO> roles;
}
