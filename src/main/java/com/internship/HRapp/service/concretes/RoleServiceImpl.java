package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.mapper.RoleMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl{

    @Autowired
    private final RoleRepo rolesRepo;
    @Autowired
    private final RoleMapper roleMapper;

    public RoleDTO getRoleById(UUID roleId) {
        boolean exists = rolesRepo.existsById(roleId);
        if (!exists){
            throw new IllegalStateException(
                    "Role with id " + roleId + " does not exist!"
            );
        }
        return roleMapper.toDTO(rolesRepo.getById(roleId));
    }
    public RoleDTO getRoleByRoleName(String roleName) {
        return roleMapper.toDTO(rolesRepo.findByRoleName(roleName));
    }

    public List<RoleDTO> getRoles() {
        return roleMapper.toDTOs(rolesRepo.findAll());
    }

    public RoleDTO addNewRoles(RoleDTO roleDTO) {
        Role createdRole = roleMapper.toEntity(roleDTO);
        rolesRepo.save(createdRole);
        return roleMapper.toDTO(createdRole);
    }
    public String deleteRolesById(UUID roleId) {
        boolean exists = rolesRepo.existsById(roleId);
        if (!exists){
            throw new IllegalStateException(
                    "Role with id " + roleId + " does not exist!"
            );
        }
        rolesRepo.deleteById(roleId);
        return "role removed {} " + roleId;
    }
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        rolesRepo.save(role);
        return roleMapper.toDTO(role);
    }
}
