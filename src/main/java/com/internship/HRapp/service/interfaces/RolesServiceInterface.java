package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Roles;

import java.util.List;
import java.util.UUID;

public interface RolesServiceInterface {

    void getRole(Roles roles);

    List<Roles> getRoles();

    void updateRoles(UUID roleId, String roleName);

    void addNewRoles(Roles roles);

    void deleteRoles(UUID roleId);
}
