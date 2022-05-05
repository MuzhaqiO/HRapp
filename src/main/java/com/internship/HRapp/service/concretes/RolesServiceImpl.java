package com.internship.HRapp.service.concretes;

import com.internship.HRapp.entity.Roles;
import com.internship.HRapp.repository.RolesRepo;
import com.internship.HRapp.service.interfaces.RolesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesServiceInterface {

    private final RolesRepo rolesRepo;

    @Override
    public void getRole(Roles roles) {

    }

    @Override
    public List<Roles> getRoles() {
        return null;
    }

    @Override
    public void updateRoles(UUID roleId, String roleName) {

    }

    @Override
    public void addNewRoles(Roles roles) {

    }

    @Override
    public void deleteRoles(UUID roleId) {

    }
}
