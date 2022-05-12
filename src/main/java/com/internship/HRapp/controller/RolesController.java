package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Roles;
import com.internship.HRapp.service.concretes.RolesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/roles")
@RequiredArgsConstructor
public class RolesController {
    private final RolesServiceImpl rolesServiceImpl;

    @GetMapping
    public List<Roles> getRoles() {
        return rolesServiceImpl.getRoles();
    }
    @GetMapping("id/{roleId}")
    public Roles getRoleById(@PathVariable UUID roleId){
        return rolesServiceImpl.getRoleById(roleId);
    }
    @GetMapping("name/{roleName}")
    public Roles getRoleByRoleName(@PathVariable String roleName){
        return rolesServiceImpl.getRoleByRoleName(roleName);
    }
    @PostMapping("addRole")
    public Roles registerNewRoles(@RequestBody Roles roles){
        return rolesServiceImpl.addNewRoles(roles);
    }
    @DeleteMapping("delete/{roleId}")
    public String deleteRolesById(@PathVariable UUID roleId){
        return rolesServiceImpl.deleteRolesById(roleId);
    }
    @PutMapping("update/{roleId}")
    public Roles updateRoles(Roles roles){
        return rolesServiceImpl.updateRoles(roles);}
}
