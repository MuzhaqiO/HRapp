package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponseDTO {
//    private final User user;
    private final String jwt;
//    private final UserDetails userDetails;

//    public AuthResponseDTO(User user, String jwt) {
//        this.user = user;
//        this.jwt = jwt;
//    }

//    private final String username;
//    private final String password;
//    private final Collection<? extends GrantedAuthority> authorities;



}
