package com.internship.HRapp.dto.userDTO;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Role;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AssignRoleDTO {
    private UUID roleId;
}
