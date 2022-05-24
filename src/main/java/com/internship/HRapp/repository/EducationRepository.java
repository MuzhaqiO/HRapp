package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> {
    //@Query(value = "select educationId from Education ")
    Education findEducationByEducationId(UUID educationId);
//    @Query(value = "select educationId from Educations c" +
//        "left join Users_Educations up on c.id= up.educationId"+
//        "where up.user_id=:userId", nativeQuery = true)
}
