package com.internship.HRapp.dto.roleDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AssignRoleDTO {
    private UUID userId;
    private UUID roleId;

}
