package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.mapper.RoleMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServiceInterface {

    private final RoleRepo rolesRepo;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO getRoleById(UUID roleId) {
        return roleMapper.toDTO(rolesRepo.getById(roleId));
    }
    @Override
    public RoleDTO getRoleByRoleName(String roleName) {
        return roleMapper.toDTO(rolesRepo.findByRoleName(roleName));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return roleMapper.toDTOs(rolesRepo.findAll());
    }

    @Override
    public RoleDTO addNewRoles(RoleDTO roleDTO) {
        Role createdRole = rolesRepo.save(roleMapper.toEntity(roleDTO));
        return roleMapper.toDTO(createdRole);
    }
    @Override
    public String deleteRolesById(UUID roleId) {
        rolesRepo.deleteById(roleId);
        return "role removed {}" + roleId;
    }
    @Override
    public void updateRole(RoleDTO roleDTO) {
        Role role = rolesRepo.findRoleByRoleId (roleDTO.getRoleId());
        role.setRoleName(roleDTO.getRoleName());
        rolesRepo.save(role);
    }
}
