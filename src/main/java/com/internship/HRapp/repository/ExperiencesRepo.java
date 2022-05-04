package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Experiences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperiencesRepo extends JpaRepository<Experiences, Long> {
    Experiences findByUserId(Long userId);
}
