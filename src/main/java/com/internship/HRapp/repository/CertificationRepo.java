package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationRepo extends JpaRepository<Certification, UUID> {

    @Override
    List<Certification> findAll();

    @Query("SELECT CertificationID FROM Certification ")
    Certification findbyCertificationId(UUID Certification);

    @Query("SELECT releasing_authority FROM Certification")
    Certification findByReleasing_authority(String releasing_authority);



}
