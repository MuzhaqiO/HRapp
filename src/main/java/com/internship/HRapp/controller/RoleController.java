package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.dto.userDTO.UserCreateDTO;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceInterface roleServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDTO>> findAllRoles(){
        return ResponseEntity.ok(roleServiceInterface.getRoles());
    }
    @GetMapping("id/{roleId}")
    public ResponseEntity<RoleDTO> findRoleById(@PathVariable UUID roleId){
        return ResponseEntity.ok(roleServiceInterface.getRoleById(roleId));
    }
    @GetMapping("name/{roleName}")
    public ResponseEntity<RoleDTO> findRoleByName(@PathVariable String roleName){
        return ResponseEntity.ok(roleServiceInterface.getRoleByRoleName(roleName));
    }
    @PostMapping("addRole")
    public ResponseEntity<RoleDTO> createNewRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleServiceInterface.addNewRoles(roleDTO));
    }
    @DeleteMapping("delete/{roleId}")
    public String deleteRolesById(@PathVariable UUID roleId){
        return roleServiceInterface.deleteRolesById(roleId);
    }
    @PutMapping("updateRole/{roleId}")
    public void updateRole(@RequestParam RoleDTO roleDTO){
        roleServiceInterface.updateRole(roleDTO);
    }
}
