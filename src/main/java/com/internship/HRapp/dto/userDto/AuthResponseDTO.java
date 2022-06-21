package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponseDTO {
    private final User user;
    private final String jwt;
}
