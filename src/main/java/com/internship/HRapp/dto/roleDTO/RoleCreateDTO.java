package com.internship.HRapp.dto.roleDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleCreateDTO {
    private UUID roleId;
    private String roleName;
}
