package com.internship.HRapp.dto.userDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class GetUsersDTO {
    private UUID userId;
    private String username;
}
