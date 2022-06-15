package com.internship.HRapp.repository;

import com.internship.HRapp.dto.ProjectsDTO;
import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectsRepo extends JpaRepository<Projects, UUID> {
  // List<Projects> findByUserId(UUID userId);

    Projects getProjectsByProjectId(UUID projectId);


    @Query(value = "select * from Projects p " +
            "left join User_Projects up on p.id = up.project_id " +
            "where up.user_id =:userId", nativeQuery = true)
    List<Projects> getProjectsByUserId(@Param("userId") UUID userId);

    @Query("SELECT p FROM Projects p WHERE p.projectName=?1")
     Projects findByProjectsName(String projectName);



    //List<User> getByUsersByProjectId(@Param("projectId") UUID projectId);
}
