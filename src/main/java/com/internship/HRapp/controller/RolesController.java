package com.internship.HRapp.controller;

import com.internship.HRapp.entity.Roles;
import com.internship.HRapp.service.concretes.RolesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/hr_management_system/roles")
@RequiredArgsConstructor
public class RolesController {
    private final RolesServiceImpl rolesServiceImpl;

    @GetMapping
    public List<Roles> getRoles() {
        return rolesServiceImpl.getRoles();
    }
    public void getRole(Roles role){
        rolesServiceImpl.getRole(role);
    }
    @PostMapping
    public void registerNewRoles(@RequestBody Roles roles){
        rolesServiceImpl.addNewRoles(roles);
    }
}
