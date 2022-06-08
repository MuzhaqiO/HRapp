package com.internship.HRapp.repository;

import com.internship.HRapp.dto.roleDTO.RoleDTO;
import com.internship.HRapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {
    Role findByRoleName(String roleName);
    Role findRoleByRoleId(UUID roleId);
}
