package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.service.concretes.RoleServiceImpl;
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
    private final RoleServiceImpl roleService;

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDTO>> findAllRoles(){
        return ResponseEntity.ok(roleService.getRoles());
    }
    @GetMapping("id/{roleId}")
    public ResponseEntity<RoleDTO> findRoleById(@PathVariable UUID roleId){
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }
    @GetMapping("name/{roleName}")
    public ResponseEntity<RoleDTO> findRoleByName(@PathVariable String roleName){
        return ResponseEntity.ok(roleService.getRoleByRoleName(roleName));
    }
    @PostMapping("addRole")
    public ResponseEntity<RoleDTO> createNewRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleService.addNewRoles(roleDTO));
    }
    @DeleteMapping("delete/{roleId}")
    public String deleteRolesById(@PathVariable UUID roleId){
        return roleService.deleteRolesById(roleId);
    }
    @PutMapping("updateRole/{roleId}")
    public void updateRole(@RequestBody RoleDTO roleDTO){
        roleService.updateRole(roleDTO);
    }
}
