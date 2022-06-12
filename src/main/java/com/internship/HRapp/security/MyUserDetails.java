package com.internship.HRapp.security;


import com.internship.HRapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.internship.HRapp.entity.User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User by username " + username + " doesn't exist");
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
