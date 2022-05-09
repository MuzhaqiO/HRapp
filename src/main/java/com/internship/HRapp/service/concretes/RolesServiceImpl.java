package com.internship.HRapp.service.concretes;

import com.internship.HRapp.entity.Roles;
import com.internship.HRapp.repository.RolesRepo;
import com.internship.HRapp.service.interfaces.RolesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesServiceInterface {

    private final RolesRepo rolesRepo;

    @Override
    public Roles getRoleById(UUID roleId) {
    return rolesRepo.findById(roleId).orElse(null);
    }
    @Override
    public Roles getRoleByRoleName(String roleName) {
        return rolesRepo.findByRoleName(roleName);
    }

    @Override
    public List<Roles> getRoles() {
        return rolesRepo.findAll();
    }

    @Override
    public Roles updateRoles(Roles roles) {
    Roles existingRole = rolesRepo.findById(roles.getRoleId()).orElse(null);
    existingRole.setRoleName(roles.getRoleName());
    return rolesRepo.save(existingRole);
    }

    @Override
    public Roles addNewRoles(Roles roles) {
    return rolesRepo.save(roles);
    }

    @Override
    public String deleteRolesById(UUID roleId) {
    rolesRepo.deleteById(roleId);
    return "role removed {}" + roleId;
    }
}
