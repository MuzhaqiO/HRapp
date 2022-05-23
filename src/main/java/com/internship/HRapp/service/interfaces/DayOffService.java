package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.StatusDTO;
import com.internship.HRapp.dto.UserDayOffDTO;
import com.internship.HRapp.dto.createDayOffDTO;

import java.util.List;
import java.util.UUID;

public interface DayOffService {

   // UserDayOffDTO getUserDayOff(UUID userId);

    UserDayOffDTO placeDayOffRequest(createDayOffDTO requestDTO);

    void deleteDayOff(UUID dayOffId);

    void updateDayOffRequest(StatusDTO status);
    List<UserDayOffDTO> getUserDayOff(UUID userId);

    //void updateLeaveDaysLeft();



}
