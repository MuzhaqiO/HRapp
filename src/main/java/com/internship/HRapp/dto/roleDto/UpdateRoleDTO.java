package com.internship.HRapp.dto.roleDto;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import com.internship.HRapp.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleDTO {
    private List<RoleDTO> roles;
}