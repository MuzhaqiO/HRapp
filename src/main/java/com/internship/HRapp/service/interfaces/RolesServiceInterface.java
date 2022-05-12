package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Roles;

import java.util.List;
import java.util.UUID;

public interface RolesServiceInterface {

    Roles getRoleById(UUID roleId);

    Roles getRoleByRoleName(String roleName);

    List<Roles> getRoles();

    Roles updateRoles(Roles roles);

    Roles addNewRoles(Roles roles);

    String deleteRolesById(UUID roleId);
}
