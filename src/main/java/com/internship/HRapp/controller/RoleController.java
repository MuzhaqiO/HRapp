package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.service.concretes.RoleService;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/hr_management_system/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceInterface roleServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDTO>> findAllRoles(){
        return ResponseEntity.ok(roleServiceInterface.getRoles());
    }
    @GetMapping("getRoleById/{roleId}")
    public ResponseEntity<RoleDTO> findRoleById(@PathVariable UUID roleId){
        return ResponseEntity.ok(roleServiceInterface.getRoleById(roleId));
    }
    @GetMapping("getRoleByName/{roleName}")
    public ResponseEntity<RoleDTO> findRoleByName(@PathVariable String roleName){
        return ResponseEntity.ok(roleServiceInterface.getRoleByRoleName(roleName));
    }
    @PostMapping("addRole")
    public ResponseEntity<RoleDTO> createNewRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleServiceInterface.addNewRoles(roleDTO));
    }
    @DeleteMapping("deleteRole/{roleId}")
    public String deleteRolesById(@PathVariable UUID roleId){
        return roleServiceInterface.deleteRolesById(roleId);
    }
    @PutMapping("updateRole/{roleId}")
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleServiceInterface.updateRole(roleDTO));
    }
    @GetMapping("getRoleByUser/{userId}")
    public ResponseEntity<List<RoleDTO>> getRoleByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(roleServiceInterface.getRoleByUserId(userId));
    }
}
