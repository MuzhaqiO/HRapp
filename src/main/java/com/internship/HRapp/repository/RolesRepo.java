package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepo extends JpaRepository<Roles, UUID> {
    Roles findByRoleName(String roleName);
}
