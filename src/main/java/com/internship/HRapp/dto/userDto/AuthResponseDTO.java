package com.internship.HRapp.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class AuthResponseDTO {
    private final String jwt;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> role;

}
