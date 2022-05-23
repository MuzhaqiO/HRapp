package com.internship.HRapp.repository;

import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DayOffRepository
        extends JpaRepository<DayOff, UUID> {
    //@Query("select Users from Users ")

    DayOff getDayOffByUsersUserId(UUID userID);
    User findByUsersUserId(UUID userID);
    DayOff findDayOffByDayOffId(UUID dayOffId);
    DayOff getDayOffByDayOffId(UUID dayOffId);

    List<DayOff> getByUsersUserId(UUID userId);


//    @Query("Select status from DayOff ")
//    DayOff getByStatus(@Param("Approved") String approved);
}
