package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.roleDTO.RoleDTO;

import java.util.List;
import java.util.UUID;

public interface RoleServiceInterface {

    RoleDTO getRoleById(UUID roleId);

    RoleDTO getRoleByRoleName(String roleName);

    List<RoleDTO> getRoles();

    RoleDTO addNewRoles(RoleDTO roleDTO);
}
