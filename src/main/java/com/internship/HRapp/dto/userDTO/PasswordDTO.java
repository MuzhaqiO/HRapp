package com.internship.HRapp.dto.userDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PasswordDTO {
    private UUID userId;
    private String oldPassword;
    private String newPassword;
}
