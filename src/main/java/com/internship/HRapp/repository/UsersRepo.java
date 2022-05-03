package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByUsername(String username);
}
