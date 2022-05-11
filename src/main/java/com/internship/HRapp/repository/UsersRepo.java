package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {
    Users findByEmail(String email);
    Users findByUsername(String username);

   // List<Experiences> getExperiencesByUsers(UUID userId);
}