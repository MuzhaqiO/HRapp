package com.internship.HRapp.dto.userDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UsersStatusDTO {
    private UUID userId;
    private Boolean usersStatus;
}
