package com.internship.HRapp.repository;

import com.internship.HRapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    User findByEmail(String email);
    User findByUsername(String username);
    User getByUsername(String username);
    User findUserByUserId(UUID userId);
    List<User> findAllByDaysOffDayOffId(UUID dayOffId);
    List<User> getUserByProjectsProjectId(UUID projectId);

}
